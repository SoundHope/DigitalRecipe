package com.uisrael.DigitalRecipe.repository;

import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeStepRepository extends JpaRepository<RecipeStep, Integer> {

}
