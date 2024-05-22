package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.services.IIngredientService;
import com.uisrael.DigitalRecipe.services.IRecipeService;
import com.uisrael.DigitalRecipe.services.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClientIngredientController {

    @Autowired
    IIngredientService serv;

    @Autowired
    IRegionService regionServ;

    @Autowired
    IRecipeService recipeServ;


    @GetMapping("ingredientrecipe/{recipeId}")
    public String ingredient(Model model, @PathVariable("recipeId") int recipeId) {
        model.addAttribute("recipeId", recipeId);
        Recipe recipe = recipeServ.getById(recipeId);
        model.addAttribute("objectsList", serv.getAllByRecipe(recipe));
        model.addAttribute("objectsListRegion", regionServ.getAll());
        return "clientIngredient/index";
    }


}
