package com.uisrael.DigitalRecipe.services;

import com.uisrael.DigitalRecipe.model.Recipe;

import java.util.List;

public interface IRecipeService {
    List<Recipe> getAll();
    void save(Recipe object);
    void deleteById(int id);
    Recipe getById(int id);

}
