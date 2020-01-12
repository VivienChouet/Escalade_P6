package com.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerHome {

    @RequestMapping(value = "/")
    public String Home(Model model) {
        model.addAttribute("pageTitle", "Home Page");

        return "home";
 // test //
    }
}
