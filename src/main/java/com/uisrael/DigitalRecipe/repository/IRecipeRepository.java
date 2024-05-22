package com.uisrael.DigitalRecipe.repository;

import com.uisrael.DigitalRecipe.model.Ingredient;
import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
    @Query("SELECT i FROM Recipe i WHERE i.region = :region")
    List<Recipe> findByRegion(@Param("region") Region region);

    @Query("SELECT r FROM Recipe r WHERE r.region = :region AND (r.descripcionReceta LIKE %:keyword% OR r.nombreReceta LIKE %:keyword%)")
    List<Recipe> findByRegionAndKeyword(@Param("region") Region region, @Param("keyword") String keyword);
}
