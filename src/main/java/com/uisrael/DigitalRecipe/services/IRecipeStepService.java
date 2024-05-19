package com.uisrael.DigitalRecipe.services;

import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.RecipeStep;

import java.util.List;

public interface IRecipeStepService {
    List<RecipeStep> getAll();
    List<RecipeStep> getAllByRecipe(Recipe recipe);
    void save(RecipeStep object);
    void deleteById(int id);
    RecipeStep getById(int id);

}
