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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<Site> sites = siteService.findByUserId();
        List<Topo> topos = topoService.findCreatorOfTopo();
        model.addAttribute("sites", sites);
        model.addAttribute("topos", topos);
        model.addAttribute("pageTitle", "Gestion Site");
        return "site/site-gestion";
    }


    @RequestMapping(value = "site/list")
    public String siteList(Model model, String search) {
        model.addAttribute("search", search);
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
        Message newComment = new Message();
        List<Message> listComment = messageService.findBySiteId(id);
        model.addAttribute("site", site);
        model.addAttribute("voie", voie);
        model.addAttribute("newComment", newComment);
        model.addAttribute("listComment", listComment);
        return "site/site-info";
    }

    @RequestMapping(value = "site/info/commentaire/{id}", method = RequestMethod.POST)
    public ModelAndView ajoutCommentaire(@PathVariable("id") Integer id, Message message) {

        messageService.AjoutCommentaire(id, message);
        return new ModelAndView("redirect:/site/info/{id}");
    }

    @RequestMapping(value = "site/commentaire/gestion/{id}")
    public String modificationCommentaire(@PathVariable("id") Integer id, Model model) {
        Site site = siteService.findById(id);
        List<Voie> voie = voieService.findBySite(id);
        Message modifyComment = new Message();
        List<Message> listComment = messageService.findBySiteId(id);
        model.addAttribute("site", site);
        model.addAttribute("voie", voie);
        model.addAttribute("modifyComment", modifyComment);
        model.addAttribute("listComment", listComment);
        return "site/site-updatecomment";
    }

    @RequestMapping(value = "site/commentaire/modify/{id}", method = RequestMethod.POST)
    public ModelAndView modidificationCommentaireForms(@PathVariable("id") Integer id, Message message) {
        messageService.updateComment(id, message);
        return new ModelAndView("redirect:/site/list");
    }

    @RequestMapping(value = "/site/recherche")
    public String rechercheSite(Model model, @RequestParam(name = "name") String name, @RequestParam(name = "contact") String contact) {
        model.addAttribute("siteList", siteService.research(name, contact));
        return "site/site-recherche";
    }

}