package com.escalade.controller;

import com.escalade.entity.Role;
import com.escalade.entity.Users;
import com.escalade.services.RoleService;
import com.escalade.services.UsersService;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    UsersService usersService;
    RoleService roleService;

    public AdminController(UsersService usersService, RoleService roleService) {
        this.usersService = usersService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/admin")
    public String Admin(Model model, HttpServletRequest request) {
        Users users = new Users();
        model.addAttribute("users", usersService.findAll());
        model.addAttribute("pageTitle", "Gestion Admin");
        request.isUserInRole("ADMIN");
        return "admin/admin";
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String ChangeRole(Model model, @PathVariable Integer id) {
        Users user = usersService.findById(id).get();
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Update");
        logger.info("list des roles : " + roles);
        logger.info("Info user de : " + user);
        return "update_user";
    }

    @RequestMapping(value = "/update_user/{id}", method = RequestMethod.POST)
    public String ChangeRole(@PathVariable("id") Integer id, @ModelAttribute Users user, BindingResult result, Model model, Role role) {
        System.out.println("user" + user + "ok");
        usersService.ChangeRoleUser(user, id);
        return "home";
    }

    @RequestMapping(value = "user/delete/{id}")
    public ModelAndView deleteUsers(@PathVariable("id") Integer id) {
        usersService.delete(id);
        return new ModelAndView("redirect:/admin");
    }


}

