package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.RecipeStep;
import com.uisrael.DigitalRecipe.model.Store;
import com.uisrael.DigitalRecipe.services.IRecipeStepService;
import com.uisrael.DigitalRecipe.services.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/step")
public class RecipeStepController {
    @Autowired
    IRecipeStepService serv;

    @GetMapping("/")
    public String region(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        return "step/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", new RecipeStep());
        return "step/form";
    }
    @GetMapping("/update/{id}")
    public String create(Model model, @PathVariable("id") int objectId) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", serv.getById(objectId));
        return "step/form";
    }

    @PostMapping("/save")
    public String save(RecipeStep object) {
        serv.save(object);
        return "redirect:/step/";
    }

    @GetMapping("/delete/{id}")
    public String save(@PathVariable("id") int objectId){
        serv.deleteById(objectId);
        return "redirect:/step/";
    }
}
