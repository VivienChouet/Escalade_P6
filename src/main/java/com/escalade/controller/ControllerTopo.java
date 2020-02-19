package com.escalade.controller;

import com.escalade.entity.Topo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerTopo {

    @RequestMapping(value = "/topo")
    public String topo() {

        return "topo";
    }

    @RequestMapping(value = "/topo/list")
    public String listtopo() {

        return "topo-list";
    }

    @RequestMapping(value = "/topo-creation", method = RequestMethod.GET)
    public String creationtopo(Model model) {
        Topo topo = new Topo();
        model.addAttribute("todo", topo);
        model.addAttribute("pageTitle", "Nouveau Topo");

        return "topo-creation";
    }

    @RequestMapping(value = "/topo-creation", method = RequestMethod.POST)
    public String creationtopo(@ModelAttribute Topo topo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("topo", topo);
            System.out.println(topo);

            return "topo-creation";
        }

        System.out.println(topo);


        return "topo-creation";
    }


}
