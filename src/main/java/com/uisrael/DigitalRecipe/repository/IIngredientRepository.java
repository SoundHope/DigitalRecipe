package com.uisrael.DigitalRecipe.repository;

import com.uisrael.DigitalRecipe.model.Ingredient;
import com.uisrael.DigitalRecipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query("SELECT i FROM Ingredient i WHERE i.recipe = :recipe")
    List<Ingredient> findByRecipe(@Param("recipe") Recipe recipe);
}
