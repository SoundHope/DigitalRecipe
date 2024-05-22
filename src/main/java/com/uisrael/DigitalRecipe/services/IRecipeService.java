package com.uisrael.DigitalRecipe.services;

import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.Region;

import java.util.List;

public interface IRecipeService {
    List<Recipe> getAll();
    List<Recipe> getAllByRegion(Region region);
    void save(Recipe object);
    void deleteById(int id);
    Recipe getById(int id);
    List<Recipe> getAllByRegionAndNameAndRecipe(Region region, String name);
}
