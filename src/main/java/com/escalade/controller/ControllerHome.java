package com.escalade.controller;

import com.escalade.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControllerHome {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/")
    public String Home(Model model, HttpServletRequest request) {

        model.addAttribute("pageTitle", "Home Page");

        return "home";
        // test //
    }
}
