package com.escalade.controller;

import com.escalade.entity.Voie;
import com.escalade.services.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerVoie {

    @Autowired
    VoieService voieService;

    @RequestMapping(value = "voie/gestion", method = RequestMethod.GET)
    public String GestionVoie(Model model) {
        Voie voie = new Voie();
        model.addAttribute("pageTitle", "Gestion Voie");
        model.addAttribute("voie", voie);
        return "voie/voie-gestion";
    }


}
