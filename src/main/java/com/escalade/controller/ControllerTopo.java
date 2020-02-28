package com.escalade.controller;

import com.escalade.entity.Topo;
import com.escalade.services.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerTopo {

    @Autowired
    TopoService topoService;

    @RequestMapping(value = "/topo")
    public String topo() {

        return "topo_gestion";
    }


    @RequestMapping(value = "/topo/gestion", method = RequestMethod.GET)
    public String creationtopo(Model model) {
        Topo topo = new Topo();
        model.addAttribute("topo", topo);
        model.addAttribute("pageTitle", "Nouveau Topo");

        return "topo_gestion";
    }

    @RequestMapping(value = "/topo/creation", method = RequestMethod.POST)
    public String creationtopo(@ModelAttribute Topo topo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("topo", topo);
            System.out.println(topo);

            return "topo_gestion";
        }

        System.out.println(topo);


        return "topo-creation";
    }

    @RequestMapping(value = "topo/list")
    public String listtopo(Model model) {
        Topo topo = new Topo();
        model.addAttribute("topo", topoService.findAll());

        return "topo-list";
    }

}
