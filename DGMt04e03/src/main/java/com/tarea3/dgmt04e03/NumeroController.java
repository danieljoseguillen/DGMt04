package com.tarea3.dgmt04e03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class NumeroController {

    @Autowired
    private Servicios servicio;
    
    @GetMapping({"/","/list","","home"})
    public String showlist(Model model){
        model.addAttribute("cantidadTotal", servicio.getLista().size());
        model.addAttribute("listaNumeros", servicio.getLista());
        return "index";
    }

    @GetMapping("/new")
    public String showNew(){
        servicio.agregar();
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete (@PathVariable Integer id) {
        servicio.remover(id);
        return "redirect:/list";
    }
    
}
