package com.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerSite {

    @RequestMapping(value = "/site/{id}")
    public String siteList(Model model, @PathVariable Integer id) {
        return "site-list";
    }
}