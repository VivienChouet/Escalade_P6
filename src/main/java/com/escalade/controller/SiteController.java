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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SiteController {

    @Autowired
    SiteService siteService;
    @Autowired
    TopoService topoService;
    @Autowired
    VoieService voieService;
    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/site/gestion")
    public String siteGestion(Model model) {
        Site site = new Site();
        List<Topo> topos = topoService.findCreatorOfTopo();
        model.addAttribute("site", site);
        model.addAttribute("topos", topos);
        model.addAttribute("pageTitle", "Gestion Site");
        return "site/site-gestion";
    }


    @RequestMapping(value = "site/list")
    public String siteList(Model model) {
        model.addAttribute("site", siteService.findAll());
        model.addAttribute("pageTitle", "List Site");
        return "site/site-list";
    }

    @RequestMapping(value = "/site/update/{id}", method = RequestMethod.GET)
    public String updateSite(@PathVariable("id") Integer id, Model model) {
        Site site = this.siteService.findById(id);
        List<Topo> topos = this.topoService.findCreatorOfTopo();
        model.addAttribute("site", site);
        model.addAttribute("topos", topos);
        model.addAttribute("pageTitle", "Update Site");
        return "site/site-update";
    }

    @RequestMapping(value = "/site/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateSite(Site site) {
        System.out.println("site = " + site);
        siteService.updateSite(site);
        return new ModelAndView("redirect:/site/list");
    }

    @RequestMapping(value = "site/new", method = RequestMethod.GET)
    public String ajoutSite(Model model) {
        Site site = new Site();
        List<Topo> topos = this.topoService.findCreatorOfTopo();
        model.addAttribute("site", site);
        model.addAttribute("topos", topos);
        return "site/site-new";
    }

    @RequestMapping(value = "site/new", method = RequestMethod.POST)
    public ModelAndView ajoutSite(Site site) {
        siteService.newSite(site);
        return new ModelAndView("redirect:/site/list");
    }

    @RequestMapping(value = "site/info/{id}")
    public String detailSite(@PathVariable("id") Integer id, Model model) {
        Site site = siteService.findById(id);
        List<Voie> voie = voieService.findBySite(id);
        Message message = new Message();
        model.addAttribute("site", site);
        model.addAttribute("voie", voie);
        model.addAttribute("message", message);

        return "site/site-info";
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