package com.uisrael.DigitalRecipe.services.impl;

import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.RecipeStep;
import com.uisrael.DigitalRecipe.repository.IRecipeRepository;
import com.uisrael.DigitalRecipe.repository.IRecipeStepRepository;
import com.uisrael.DigitalRecipe.services.IRecipeService;
import com.uisrael.DigitalRecipe.services.IRecipeStepService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecipeStepServiceImpl implements IRecipeStepService {

    @Autowired
    private IRecipeStepRepository repo;

    @Override
    public List<RecipeStep> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(RecipeStep object) {
        repo.save(object);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public RecipeStep getById(int id) {
        return repo.findById(id).get();
    }
}
