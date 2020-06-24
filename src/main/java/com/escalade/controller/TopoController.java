package com.escalade.controller;

import com.escalade.entity.Topo;
import com.escalade.services.ReservationService;
import com.escalade.services.SiteService;
import com.escalade.services.TopoService;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TopoController {

    @Autowired
    TopoService topoService;
    @Autowired
    SiteService siteService;
    @Autowired
    ReservationService reservationService;


    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping(value = "/topo/new", method = RequestMethod.GET)
    @RolesAllowed("ADMIN")
    public String CreationTopo(Model model) {
        Topo topo = new Topo();
        List<Topo> ListTopo = topoService.findAll();
        model.addAttribute("topo", topo);
        model.addAttribute("topoList", ListTopo);
        model.addAttribute("pageTitle", "New Topo");
        return "topo/topo-new";
    }

    @RequestMapping(value = "/topo/new", method = RequestMethod.POST)
    public String CreationTopo(@ModelAttribute Topo topo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("topo", topo);
            model.addAttribute("pageTitle", "New Topo");
            logger.warn("error " + topo);
            return "topo/topo-new";
        }
        topoService.RegisterNewTopo(topo);
        return "home";
    }

    @RequestMapping(value = "/topo/list")
    public String listTopo(Model model, String search) {
        model.addAttribute("search", search);
        model.addAttribute("pageTitle", "List Topo");
        model.addAttribute("topoList", topoService.listTopoPublic());
        return "topo/topo-list";
    }

    @RequestMapping(value = "topo/gestion", method = RequestMethod.GET)
    public String gestionTopo(Model model, HttpServletRequest request) {
        List<Topo> topos = this.topoService.listTopoUserLogged();
        model.addAttribute("listTopo", topos);
        model.addAttribute("pageTitle", "Gestion des Topos");
        return "topo/topo-gestion";
    }

    @RequestMapping(value = "topo/info/{id}")
    public String infoTopo(@PathVariable("id") Integer id, Model model) {
        Topo topo = this.topoService.findById(id);
        model.addAttribute("topo", topo);
        return "topo/topo-info";
    }


    @RequestMapping(value = "/topo/update/{id}", method = RequestMethod.POST)
    public String updateTopo(@PathVariable("id") Integer id, Topo topo) {
        topo.setId(id);
        logger.info("Log Topo POST = " + topo);
        topoService.updateTopo(topo);
        return "topo/topo-list";
    }


    @RequestMapping(value = "/topo/recherche")
    public String rechercheTopo(Model model, @RequestParam(name = "name") String name, @RequestParam(name = "lieux") String lieux) {
        model.addAttribute("topoList", topoService.research(name, lieux));
        return "topo/topo-recherche";
    }

    @RequestMapping(value = "/topo/reservation/{id}", method = RequestMethod.POST)
    public String reservationTopo(@PathVariable("id") Integer id, Model model) {
        Topo topo = this.topoService.findById(id);
        model.addAttribute("topo", topo);
        reservationService.newReservation(id);
        topoService.newReservation(id);
        return "topo/topo-info";
    }

    @RequestMapping(value = "/topo/officialTopo/{id}", method = RequestMethod.POST)
    public String officielTopo(@PathVariable("id") Integer id) {
        topoService.setOfficialTopo(id);
        return "home";
    }

    @RequestMapping(value = "/topo/unofficialTopo/{id}", method = RequestMethod.POST)
    public String unofficielTopo(@PathVariable("id") Integer id) {
        topoService.setUnOfficialTopo(id);
        return "home";
    }


}
