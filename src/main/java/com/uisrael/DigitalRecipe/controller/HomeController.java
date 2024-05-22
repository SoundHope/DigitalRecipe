package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.services.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    IRegionService serv;


    @GetMapping("/")
    public String region(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        return "home/index";
    }
}
