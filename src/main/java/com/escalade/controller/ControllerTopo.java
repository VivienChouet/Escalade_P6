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


    @RequestMapping(value = "topo/gestion", method = RequestMethod.POST)
    public String CreationTopo(@ModelAttribute BindingResult result, Model model) {
        Topo topo = new Topo();
        model.addAttribute("topo", topo);
        model.addAttribute("topoList", topoService.findAll());
        model.addAttribute("pageTitle", "Gestion Topo");
        return "topo_gestion";
    }

    @RequestMapping(value = "topo/gestion", method = RequestMethod.GET)
    public String CreationTopo(Topo topo) {
        topoService.RegisterNewTopo(topo);
        return "home";
    }

    @RequestMapping(value = "topo/list")
    public String LlistTopo(Model model) {

        model.addAttribute("topoList", topoService.findAll());

        return "topo-list";
    }

}
