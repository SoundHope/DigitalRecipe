package com.uisrael.DigitalRecipe.repository;

import com.uisrael.DigitalRecipe.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {

}
