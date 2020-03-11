package com.escalade.controller;

import com.escalade.entity.Site;
import com.escalade.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ControllerSite {

    @Autowired
    SiteService siteService;

    @RequestMapping(value = "/site/{id}")
    public String siteList(Model model, @PathVariable Integer id) {
        return "site-gestion";
    }

    @RequestMapping(value = "/site/gestion", method = RequestMethod.GET)
    public String SiteGestion(Model model) {
        Site site = new Site();
        model.addAttribute("site", site);
        model.addAttribute("pageTitle", "Gestion Site");
        return "site-gestion";
    }

    @RequestMapping(value = "/site/gestion", method = RequestMethod.POST)
    public String SiteGestion(Site site) {
        siteService.NewSite(site);
        return "site-list";
    }


    @RequestMapping(value = "site/list")
    public String SiteList(Model model) {
        List<Site> ListSite = siteService.findAll();
        model.addAttribute("site", ListSite);
        return "site-list";
    }
}