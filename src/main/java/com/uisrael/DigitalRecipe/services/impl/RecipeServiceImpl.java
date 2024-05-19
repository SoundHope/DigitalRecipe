package com.uisrael.DigitalRecipe.services.impl;

import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.RecipeStep;
import com.uisrael.DigitalRecipe.model.Region;
import com.uisrael.DigitalRecipe.repository.IRecipeRepository;
import com.uisrael.DigitalRecipe.services.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements IRecipeService {

    @Autowired
    private IRecipeRepository repo;

    @Override
    public List<Recipe> getAllByRegion(Region region) {
        return repo.findByRegion(region);
    }

    @Override
    public List<Recipe> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Recipe object) {
        repo.save(object);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Recipe getById(int id) {
        return repo.findById(id).get();
    }
}
