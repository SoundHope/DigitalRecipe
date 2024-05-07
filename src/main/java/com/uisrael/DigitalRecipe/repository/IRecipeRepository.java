package com.uisrael.DigitalRecipe.repository;

import com.uisrael.DigitalRecipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {

}
