package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.Ingredient;
import com.uisrael.DigitalRecipe.services.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    IIngredientService serv;

    @GetMapping("/")
    public String region(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        return "ingredient/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", new Ingredient());
        return "ingredient/form";
    }
    @GetMapping("/update/{id}")
    public String create(Model model, @PathVariable("id") int objectId) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", serv.getById(objectId));
        return "ingredient/form";
    }

    @PostMapping("/save")
    public String save(Ingredient object) {
        serv.save(object);
        return "redirect:/ingredient/";
    }

    @GetMapping("/delete/{id}")
    public String save(@PathVariable("id") int objectId){
        serv.deleteById(objectId);
        return "redirect:/ingredient/";
    }
}
