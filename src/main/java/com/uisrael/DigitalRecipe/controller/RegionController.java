package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.Region;
import com.uisrael.DigitalRecipe.services.IRegionService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/region")
public class RegionController {

    @Autowired
    IRegionService serv;

    @GetMapping("/")
    public String region(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        return "region/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", new Region());
        return "region/form";
    }
    @GetMapping("/update/{id}")
    public String create(Model model, @PathVariable("id") int objectId) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", serv.getById(objectId));
        return "region/form";
    }

    @PostMapping("/save")
    public String save(Region object) {
        serv.save(object);
        return "redirect:/region/";
    }

    @GetMapping("/delete/{id}")
    public String save(@PathVariable("id") int objectId){
        serv.deleteById(objectId);
        return "redirect:/region/";
    }
}
