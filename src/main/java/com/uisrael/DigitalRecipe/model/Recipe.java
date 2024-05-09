package com.uisrael.DigitalRecipe.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Recipe {
	
	private int id;
	private String nombreReceta;
	private String descripcionReceta;
	private String tiempoPreparacion;

}
