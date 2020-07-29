package com.escalade.controller;

import com.escalade.entity.Users;
import com.escalade.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @Autowired
    UsersService usersService;

    @Autowired
    public RegistrationController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String NewUsers(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        model.addAttribute("pageTitle", "Registration");
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String NewUsers(@ModelAttribute Users users, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", users);
            System.out.println(users);
            return "registration";
        }
        if (usersService.emailExists(users.getEmail())) {
            return "registration";
        }
        System.out.println(users);
        usersService.registerNewUserAccount(users);
        return "home";
    }

}


