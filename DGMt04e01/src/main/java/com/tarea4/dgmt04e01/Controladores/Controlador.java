package com.tarea4.dgmt04e01.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tarea4.dgmt04e01.Servicios.CalculosService;

@Controller
public class Controlador {

    @Autowired
    private CalculosService servicio;

    @GetMapping({ "/", "/index", "/home" })
    public String mainV(Model model) {
        if (servicio.getresp() != null) {
            model.addAttribute("respuesta", servicio.getresp());
            servicio.setresp(null);
        }
        if (servicio.getSize() > 0) {
            System.out.println("Divisores en el controlador: " + servicio.getDivisores());
            model.addAttribute("divisores", servicio.getDivisores());
            model.addAttribute("size", servicio.getSize());
            servicio.setSize(0);
        }
        return "indexView";
    }

    @GetMapping("/errorView")
    public String errorV(Model model) {
        if (servicio.geterr() != null) {
            model.addAttribute("error", servicio.geterr());
            servicio.seterr(null);
        }
        return "errorView";
    }

    @GetMapping("/calculos/primo")
    public String primos(@RequestParam(required = false) Integer numero, Model model) {
        if (numero == null) {
            servicio.seterr("Debe ingresarse un valor para la operación de numeros primos.");
            return "redirect:/errorView";
        }
        try {
            if (servicio.esPrimo(numero)) {
                servicio.setresp("El numero " + numero + " es primo.");
            } else {
                servicio.setresp("El numero " + numero + " no es primo.");
            }
        } catch (Exception e) {
            servicio.seterr(e.getMessage());
            return "redirect:/errorView";
        }
        return "redirect:/";
    }

    @GetMapping("/calculos/hipotenusa/{val1}/{val2}")
    public String hipotenusa(@PathVariable Integer val1, @PathVariable Integer val2, Model model) {
        try {
            servicio.setresp("La hipotenusa de " + val1 + " y " + val2 + " es: " + servicio.calchipotenusa(val1, val2));
        } catch (Exception e) {
            servicio.seterr(e.getMessage());
            return "redirect:/errorView";
        }
        return "redirect:/";
    }

    @GetMapping("/calculos/divisores/{valor}")
    public String divisores(@PathVariable Integer valor, Model model) {
        servicio.clearDivisores();
        try {
            servicio.calcdivisores(valor);
            servicio.setresp("Divisores de " + valor + ":");
        } catch (Exception e) {
            servicio.seterr(e.getMessage());
            return "redirect:/errorView";
        }
        return "redirect:/";
    }

}
