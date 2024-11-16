package com.tarea4.dgmt04e05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MathController {
    @Autowired
    private MathService mathService;
    private String txtStatus = null;

    @GetMapping("/")
    public String showInit(Model model) {
        if (txtStatus != null) {
            model.addAttribute("txtStatus", txtStatus);
            txtStatus = null;
        }
        return "indexView";
    }

    @GetMapping("/calcularHipotenusa/{cat1}/{cat2}")
    public String showHipot(@PathVariable String cat1, @PathVariable String cat2,
            Model model) {
        Double cateto1, cateto2;
        try {
            cateto1 = Double.parseDouble(cat1); // puede lanzar excepción.
            cateto2 = Double.parseDouble(cat2); // NumberFormatException para ser mas especifico.
            model.addAttribute("resultado",
                    mathService.calcularHipotenusa(cateto1, cateto2)); // otra excepción ... RuntimeException para ser mas especifico.
            return "resultadoView";
        } catch (NumberFormatException ex) { // Para captar los errores de parseDouble.
            txtStatus = "Error de parámetros: Se han introducido valores no numericos.";
            return "redirect:/";
        } catch (Exception ex) { // Para captar RuntimeException del metodo (Y cualquier otro error que pueda ocurrir).
            txtStatus = ex.getMessage();
            return "redirect:/";
        }
    }
}
