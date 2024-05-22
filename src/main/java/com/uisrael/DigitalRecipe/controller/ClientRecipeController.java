package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.Region;
import com.uisrael.DigitalRecipe.services.IRegionService;
import com.uisrael.DigitalRecipe.services.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClientRecipeController {

    @Autowired
    IRegionService regionServ;

    @Autowired
    IRecipeService serv;


    @GetMapping("clientrecipe/{regionId}")
    public String recipe(Model model, @PathVariable("regionId") int regionId) {
        model.addAttribute("regionId", regionId);
        Region region = regionServ.getById(regionId);
        model.addAttribute("objectsList", serv.getAllByRegion(region));
        model.addAttribute("objectsListRegion", regionServ.getAll());
        return "clientRegion/index";
    }

}
