package com.uisrael.DigitalRecipe.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class RecipeCommand {
    private int id;
    private String nombreReceta;
    private String descripcionReceta;
    private String tiempoPreparacion;
    private Region region;
    private List<Ingredient> ingredients;
    private List<RecipeStep> recipeSteps;
    private MultipartFile photoFile;
}
