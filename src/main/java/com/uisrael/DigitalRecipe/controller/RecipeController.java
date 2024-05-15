package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.services.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    IRecipeService serv;

    @GetMapping("/")
    public String region(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        return "recipe/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", new Recipe());
        return "recipe/form";
    }
    @GetMapping("/update/{id}")
    public String create(Model model, @PathVariable("id") int objectId) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", serv.getById(objectId));
        return "recipe/form";
    }

    @PostMapping("/save")
    public String save(Recipe object) {
        serv.save(object);
        return "redirect:/recipe/";
    }

    @GetMapping("/delete/{id}")
    public String save(@PathVariable("id") int objectId){
        serv.deleteById(objectId);
        return "redirect:/recipe/";
    }
}
