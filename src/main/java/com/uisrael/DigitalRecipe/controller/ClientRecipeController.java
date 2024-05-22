package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.Ingredient;
import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.Region;
import com.uisrael.DigitalRecipe.services.IIngredientService;
import com.uisrael.DigitalRecipe.services.IRegionService;
import com.uisrael.DigitalRecipe.services.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class ClientRecipeController {

    @Autowired
    IRegionService regionServ;

    @Autowired
    IRecipeService serv;

    @Autowired
    IIngredientService ingredientServ;


    @GetMapping("clientrecipe/{regionId}")
    public String recipe(Model model, @PathVariable("regionId") int regionId, @RequestParam(value="filtroReceta", defaultValue = "") String filtroReceta, @RequestParam(value="filtroIngrediente", defaultValue = "") String filtroIngrediente) {
        model.addAttribute("regionId", regionId);
        Region region = regionServ.getById(regionId);
        if(!"".equals(filtroReceta)){
            model.addAttribute("objectsList", serv.getAllByRegionAndNameAndRecipe(region, filtroReceta));
        }else if(!"".equals(filtroIngrediente)){
            List<Recipe> recipes = serv.getAllByRegion(region);
            Ingredient ingredient = ingredientServ.getById(Integer.parseInt(filtroIngrediente));
            int recipeId = ingredient.getRecipe().getId();
            List<Recipe> matchingRecipe = List.of(Objects.requireNonNull(recipes.stream()
                    .filter(recipe -> recipe.getId() == recipeId)
                    .findFirst()
                    .orElse(null)));
            model.addAttribute("objectsList", matchingRecipe);
        }else{
            model.addAttribute("objectsList", serv.getAllByRegion(region));
        }
        List<Ingredient> ingredientsToShow = new ArrayList<>();
        for (Ingredient ingredientToShow : ingredientServ.getAll()) {
            if(ingredientToShow.getRecipe().getRegion().getId() == regionId){
                ingredientsToShow.add(ingredientToShow);
            }
        }
        model.addAttribute("ingredients", ingredientsToShow);
        model.addAttribute("region", region);
        model.addAttribute("objectsListRegion", regionServ.getAll());
        return "clientRegion/index";
    }

}
