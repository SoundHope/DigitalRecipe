package com.uisrael.DigitalRecipe.services;

import com.uisrael.DigitalRecipe.model.Ingredient;
import com.uisrael.DigitalRecipe.model.Recipe;

import java.util.List;

public interface IIngredientService {
    List<Ingredient> getAll();
    List<Ingredient> getAllByRecipe(Recipe recipe);
    void save(Ingredient object);
    void deleteById(int id);
    Ingredient getById(int id);
}
