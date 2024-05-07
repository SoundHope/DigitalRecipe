package com.uisrael.DigitalRecipe.services;

import com.uisrael.DigitalRecipe.model.Ingredient;

import java.util.List;

public interface IIngredientService {
    List<Ingredient> getAll();
    void save(Ingredient object);
    void deleteById(int id);
    Ingredient getById(int id);
}
