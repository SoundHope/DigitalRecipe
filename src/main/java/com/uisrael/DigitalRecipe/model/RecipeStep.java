package com.uisrael.DigitalRecipe.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RecipeStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int orderPosition;
    private String description;

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "recipe")
    private Recipe recipe;
}
