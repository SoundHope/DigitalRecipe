package com.uisrael.DigitalRecipe.repository;

import com.uisrael.DigitalRecipe.model.Ingredient;
import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRecipeStepRepository extends JpaRepository<RecipeStep, Integer> {
    @Query("SELECT i FROM RecipeStep i WHERE i.recipe = :recipe")
    List<RecipeStep> findByRecipe(@Param("recipe") Recipe recipe);
}
