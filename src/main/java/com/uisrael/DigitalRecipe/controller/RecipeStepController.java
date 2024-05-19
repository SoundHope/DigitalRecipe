package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.RecipeStep;
import com.uisrael.DigitalRecipe.services.IRecipeService;
import com.uisrael.DigitalRecipe.services.IRecipeStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipeStep")
public class RecipeStepController {

    @Autowired
    IRecipeStepService serv;

    @Autowired
    IRecipeService recipeServ;

    @GetMapping("/{recipeId}")
    public String recipeStep(Model model, @PathVariable("recipeId") int recipeId) {
        model.addAttribute("recipeId", recipeId);
        Recipe recipe = recipeServ.getById(recipeId);
        model.addAttribute("objectsList", serv.getAllByRecipe(recipe));
        return "recipeStep/list";
    }

    @GetMapping("/{recipeId}/create")
    public String create(@PathVariable("recipeId") int recipeId, Model model){
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("object", new RecipeStep());
        return "recipeStep/form";
    }
    @GetMapping("/{recipeId}/update/{id}")
    public String create(Model model, @PathVariable("id") int objectId, @PathVariable("recipeId") int recipeId) {
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("object", serv.getById(objectId));
        return "recipeStep/form";
    }

    @PostMapping("/{recipeId}/save")
    public String save(RecipeStep object, @PathVariable("recipeId") int recipeId) {
        Recipe recipe = recipeServ.getById(recipeId);
        object.setRecipe(recipe);
        serv.save(object);
        return "redirect:/recipeStep/" + recipeId;
    }

    @GetMapping("/{recipeId}/delete/{id}")
    public String save(@PathVariable("id") int objectId, @PathVariable("recipeId") int recipeId){
        serv.deleteById(objectId);
        return "redirect:/recipeStep/" + recipeId;
    }
}
