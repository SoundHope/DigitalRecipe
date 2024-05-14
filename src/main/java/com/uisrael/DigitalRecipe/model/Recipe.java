package com.uisrael.DigitalRecipe.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreReceta;
	private String descripcionReceta;
	private String tiempoPreparacion;

	@ManyToOne(cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "region")
	private Region region;

	@OneToMany(mappedBy = "recipe")
	private List<Ingredient> ingredients;

	@OneToMany(mappedBy = "recipe")
	private List<RecipeStep> recipeSteps;

}
