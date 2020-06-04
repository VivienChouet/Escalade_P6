package com.escalade.controller;

import com.escalade.entity.Message;
import com.escalade.entity.Site;
import com.escalade.entity.Topo;
import com.escalade.entity.Voie;
import com.escalade.services.MessageService;
import com.escalade.services.SiteService;
import com.escalade.services.TopoService;
import com.escalade.services.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ControllerSite {

    @Autowired
    SiteService siteService;
    @Autowired
    TopoService topoService;
    @Autowired
    VoieService voieService;
    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/site/gestion", method = RequestMethod.GET)
    public String siteGestion(Model model) {
        Site site = new Site();
        List<Topo> topos = topoService.findByTopo();
        model.addAttribute("site", site);
        model.addAttribute("topos", topos);
        model.addAttribute("pageTitle", "Gestion Site");
        return "site/site-gestion";
    }

    @RequestMapping(value = "/site/gestion", method = RequestMethod.POST)
    public String siteGestion(Site site) {
        siteService.newSite(site);
        return "site/site-list";
    }


    @RequestMapping(value = "site/list")
    public String siteList(Model model) {
        model.addAttribute("site", siteService.findAll());
        return "site/site-list";
    }

    @RequestMapping(value = "/site/update/{id}", method = RequestMethod.GET)
    public String updateSite(@PathVariable("id") Integer id, Model model) {
        Site site = this.siteService.findById(id);
        List<Topo> topos = this.topoService.findByTopo();
        List<Voie> voies = this.voieService.findBySite(id);
        model.addAttribute("site", site);
        model.addAttribute("topos", topos);
        model.addAttribute("voies", voies);
        if (siteService.correspondanceUser(id) == true) {
            model.addAttribute("pageTitle", "Update Site");
            return "site/site-update";
        }
        Message message = new Message();
        model.addAttribute("message", message);
        return "site/site-info";
    }

    @RequestMapping(value = "/site/update/{id}", method = RequestMethod.POST)
    public String updateSite(Site site) {
        System.out.println("site = " + site);
        siteService.updateSite(site);
        return "site/site-list";
    }


    @RequestMapping(value = "site/info/commentaire/{id}", method = RequestMethod.POST)
    public String ajoutCommentaire(@PathVariable("id") Integer id, Model model, BindingResult result, Message message) {
        if (result.hasErrors()) {
            model.addAttribute("message", message);
            return "site/site-info";
        }
        messageService.AjoutCommentaire(id, message);
        return "site/site-info";
    }

}