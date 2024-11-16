package com.tarea4.dgmt04e04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Controlador {

    @Autowired
    private Servicios servicios;

    @GetMapping({ "/", "/index", "/home" })
    public String showIndex(Model model) {
        model.addAttribute("n1", servicios.getNum1());
        model.addAttribute("n2", servicios.getNum2());
        model.addAttribute("etapa", servicios.getStep());
        model.addAttribute("result", servicios.getResult());
        return "indexView";
    }

    @GetMapping("/digito/{number}")
    public String addDigit(@PathVariable Integer number) {
        servicios.agregar(number);
        return "redirect:/";
    }

    @GetMapping("/suma")
    public String sumar(Model model) {
        servicios.setOper("sum");
        servicios.stepup();
        return "redirect:/";
    }

    @GetMapping("/resta")
    public String restar(Model model) {
        servicios.setOper("rest");
        servicios.stepup();
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String restaurar(Model model) {
        servicios.restore();
        return "redirect:/";
    }

    @GetMapping("/igual")
    public String resultado(Model model) {
        servicios.resultado();
        return "redirect:/";
    }

}
