package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.Ingredient;
import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.Store;
import com.uisrael.DigitalRecipe.services.IIngredientService;
import com.uisrael.DigitalRecipe.services.IRecipeService;
import com.uisrael.DigitalRecipe.services.IStoreService;
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

    @Autowired
    IStoreService storeServ;

    @Autowired
    IRecipeService recipeServ;

    @GetMapping("/{recipeId}")
    public String ingredient(Model model, @PathVariable("recipeId") int recipeId) {
        model.addAttribute("recipeId", recipeId);
        Recipe recipe = recipeServ.getById(recipeId);
        model.addAttribute("objectsList", serv.getAllByRecipe(recipe));
        return "ingredient/list";
    }

    @GetMapping("/{recipeId}/create")
    public String create(@PathVariable("recipeId") int recipeId, Model model){
        model.addAttribute("recipeId", recipeId);
        Ingredient newIngredient = new Ingredient();
        model.addAttribute("object", newIngredient);
        model.addAttribute("stores", storeServ.getAll());
        return "ingredient/form";
    }
    @GetMapping("/{recipeId}/update/{id}")
    public String create(Model model, @PathVariable("id") int objectId, @PathVariable("recipeId") int recipeId) {
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("object", serv.getById(objectId));
        model.addAttribute("stores", storeServ.getAll());
        return "ingredient/form";
    }

    @PostMapping("/{recipeId}/save")
    public String save(Ingredient object, @PathVariable("recipeId") int recipeId) {
        Recipe recipe = recipeServ.getById(recipeId);
        Store store = storeServ.getById(object.getStore().getId());
        object.setRecipe(recipe);
        object.setStore(store);
        serv.save(object);
        return "redirect:/ingredient/" + recipeId;
    }

    @GetMapping("/{recipeId}/delete/{id}")
    public String save(@PathVariable("id") int objectId, @PathVariable("recipeId") int recipeId){
        serv.deleteById(objectId);
        return "redirect:/ingredient/" + recipeId;
    }
}
