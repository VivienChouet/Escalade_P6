package com.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class ControllerHome {

    @RequestMapping(value = "/")
    public String Home(Model model) {
        model.addAttribute("pageTitle", "Home Page");
        Logger.getLogger("Lancement de la page HOME");
        return "home";
        // test //
    }
}
