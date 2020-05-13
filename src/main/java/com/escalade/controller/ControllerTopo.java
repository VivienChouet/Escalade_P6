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
public class ControllerTopo {

    @Autowired
    TopoService topoService;
    @Autowired
    SiteService siteService;
    @Autowired
    ReservationService reservationService;


    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping(value = "/topo/gestion", method = RequestMethod.GET)
    @RolesAllowed("ADMIN")
    public String CreationTopo(Model model) {
        Topo topo = new Topo();
        List<Topo> ListTopo = topoService.findAll();
        model.addAttribute("topo", topo);
        model.addAttribute("topoList", ListTopo);
        model.addAttribute("pageTitle", "Gestion Topo");
        return "topo/topo-gestion";
    }

    @RequestMapping(value = "/topo/gestion", method = RequestMethod.POST)
    public String CreationTopo(@ModelAttribute Topo topo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("topo", topo);
            logger.warn("error " + topo);
            return "topo/topo-gestion";
        }

        topoService.RegisterNewTopo(topo);
        return "home";
    }

    @RequestMapping(value = "/topo/list")
    public String listTopo(Model model, String search) {
        model.addAttribute("search", search);
        model.addAttribute("topoList", topoService.findAll());
        return "topo/topo-list";
    }

    @RequestMapping(value = "/topo/update/{id}", method = RequestMethod.GET)
    public String updateTopo(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        request.isUserInRole("ADMIN");
        Topo topo = this.topoService.findById(id);
        model.addAttribute("topo", topo);
        model.addAttribute("pageTitle", "Update Topo");
        if (topoService.correspondanceUser(id) == true) {
            model.addAttribute("pageTitle", "Update Topo");
            return "topo/topo-update";
        }
        return "topo/topo-info";
    }

    @RequestMapping(value = "/topo/update/{id}", method = RequestMethod.POST)
    public String updateTopo(@PathVariable("id") Integer id, Topo topo) {
        topo.setId(id);
        topoService.updateTopo(topo);
        return "topo/topo-list";
    }


    @RequestMapping(value = "/topo/recherche")
    public String rechercheTopo(Model model, @RequestParam(name = "name") String name, @RequestParam(name = "lieux") String lieux) {
        model.addAttribute("topoList", topoService.research(name, lieux));
        return "topo/topo-recherche";
    }

    @RequestMapping(value = "/topo/checkReservation", method = RequestMethod.POST)
    public String infoTopo(Model model, @PathVariable("id") Integer id) {
        Topo topo = this.topoService.findById(id);
        model.addAttribute("Topo", topo);
        reservationService.newReservation();
        return "topo/topo-info";
    }

}
