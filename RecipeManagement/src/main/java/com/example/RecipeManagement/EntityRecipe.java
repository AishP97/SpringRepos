package com.example.RecipeManagement;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class EntityRecipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	
	@OneToMany (mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private List<EntityIngredient> ingredients = new ArrayList<>(); 
	

	public void addIngredient(EntityIngredient ingredient) {
	    ingredient.setRecipe(this);
	    this.ingredients.add(ingredient);
	}

	public EntityRecipe() {

	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EntityIngredient> getIngredients() {
		if(ingredients == null) {
			ingredients = new ArrayList<>();
		}
		return ingredients;
	}
	
	
}
