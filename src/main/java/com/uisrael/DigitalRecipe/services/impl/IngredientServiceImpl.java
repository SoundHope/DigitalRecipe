package com.uisrael.DigitalRecipe.services.impl;

import com.uisrael.DigitalRecipe.model.Ingredient;
import com.uisrael.DigitalRecipe.repository.IIngredientRepository;
import com.uisrael.DigitalRecipe.services.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IIngredientService {
    @Autowired
    private IIngredientRepository repo;

    @Override
    public List<Ingredient> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Ingredient object) {
        repo.save(object);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Ingredient getById(int id) {
        return repo.findById(id).get();
    }
}
