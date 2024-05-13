package com.uisrael.DigitalRecipe.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;


@Entity
@Data
@ToString
public class Ingredient {

private int id;	
private String nombreIngrediente;
private int cantidadIngrediente;

}
