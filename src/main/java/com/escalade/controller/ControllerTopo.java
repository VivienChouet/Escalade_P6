package com.escalade.controller;

import com.escalade.entity.Topo;
import com.escalade.services.TopoService;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ControllerTopo {

    @Autowired
    TopoService topoService;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping(value = "/topo/gestion", method = RequestMethod.GET)
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
    public String LlistTopo(Model model) {
        model.addAttribute("topoList", topoService.findAll());
        return "topo/topo-list";
    }

    @RequestMapping(value = "/topo/update/{id}", method = RequestMethod.GET)
    public String updateTopo(@PathVariable("id") Integer id, Model model, Topo topo) {
        topo.setId(id);
        model.addAttribute("topo", topo);
        model.addAttribute("pageTitle", "Update Topo");
        return "topo/topo-update";
    }

    @RequestMapping(value = "/topo/update/{id}", method = RequestMethod.POST)
    public String updateTopo(@PathVariable("id") Integer id, Topo topo) {
        topo.setId(id);
        topoService.updateTopo(topo);
        return "topo/topo-list";
    }

}
