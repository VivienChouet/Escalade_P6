package com.escalade.controller;

import com.escalade.entity.Site;
import com.escalade.entity.Topo;
import com.escalade.services.SiteService;
import com.escalade.services.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerSite {

    @Autowired
    SiteService siteService;
    @Autowired
    TopoService topoService;

    @RequestMapping(value = "/site/{id}")
    public String siteList(Model model, @PathVariable Integer id) {
        return "site-gestion";
    }

    @RequestMapping(value = "/site/gestion", method = RequestMethod.GET)
    public String SiteGestion(Model model) {
        Site site = new Site();
        Topo topo = topoService.findByTopo();
        model.addAttribute("site", site);
        model.addAttribute("topo", topo);
        model.addAttribute("pageTitle", "Gestion Site");
        return "site/site-gestion";
    }

    @RequestMapping(value = "/site/gestion", method = RequestMethod.POST)
    public String SiteGestion(Site site) {
        siteService.NewSite(site);
        return "site/site-list";
    }


    @RequestMapping(value = "site/list")
    public String SiteList(Model model) {
        model.addAttribute("site", siteService.findAll());
        return "site/site-list";
    }

    @RequestMapping(value = "/site/update/{id}", method = RequestMethod.GET)
    public String UpdateSite(@PathVariable("id") Integer id, Model model, Site site) {
        site.setId(id);
        Site sites = new Site();
        Topo topo = topoService.findByTopo();
        model.addAttribute("site", sites);
        model.addAttribute("topo", topo);
        model.addAttribute("pageTitle", "Update Site");
        return "site/site-update";
    }

    @RequestMapping(value = "/site/update/{id}", method = RequestMethod.POST)
    public String UpdateSite(@PathVariable("id") Integer id, Site site) {
        site.setId(id);
        siteService.UpdateSite(site);

        return "site/site-list";
    }

}