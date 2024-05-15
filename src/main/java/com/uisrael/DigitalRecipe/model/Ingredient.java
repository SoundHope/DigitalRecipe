package com.uisrael.DigitalRecipe.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreIngrediente;
    private int cantidadIngrediente;
    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "recipe")
    private Recipe recipe;

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "store")
    private Store store;


}
