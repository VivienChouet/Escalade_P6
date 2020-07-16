package com.escalade.controller;

import com.escalade.entity.Site;
import com.escalade.entity.Voie;
import com.escalade.services.SiteService;
import com.escalade.services.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VoieController {

    @Autowired
    VoieService voieService;

    @Autowired
    SiteService siteService;

    @RequestMapping(value = "/voie/new", method = RequestMethod.GET)
    public String ajoutVoie(Model model) {
        Voie voie = new Voie();
        List<Site> site = siteService.findByUser();
        model.addAttribute("pageTitle", "Gestion Voie");
        model.addAttribute("sites", site);
        model.addAttribute("voie", voie);
        return "voie/voie-new";
    }

    @RequestMapping(value = "/voie/new", method = RequestMethod.POST)
    public ModelAndView voieGestion(Voie voie) {
        voieService.newVoie(voie);
        return new ModelAndView("redirect:/voie/list");
    }

    @RequestMapping(value = "voie/list")
    public String voieList(Model model) {
        model.addAttribute("voie", voieService.findAll());
        return "voie/voie-list";
    }

    @RequestMapping(value = "/voie/update/{id}", method = RequestMethod.GET)
    public String updateVoie(@PathVariable("id") Integer id, Model model) {
        Voie voie = this.voieService.findById(id);
        model.addAttribute("voie", voie);
        model.addAttribute("pageTitle", "Update voie");
        return "voie/voie-update";
    }

    @RequestMapping(value = "/voie/update/{id}", method = RequestMethod.POST)
    public String updateVoie(Voie voie) {
        voieService.updateVoie(voie);
        return "voie/voie-list";
    }

}
