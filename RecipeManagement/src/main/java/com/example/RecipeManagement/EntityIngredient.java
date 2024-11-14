package com.example.RecipeManagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EntityIngredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double quantity;
	private String unit;
	
	@ManyToOne
	@JoinColumn(name = "recipeid", nullable = false)
	@JsonBackReference
	private EntityRecipe recipe;
	

	
	public EntityIngredient() {

	}
	
	public EntityIngredient(Long id, String name, double quantity, String unit) {
		this.id=id;
		this.name=name;
		this.quantity=quantity;
		this.unit=unit;
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setRecipe(EntityRecipe recipe) {
		this.recipe = recipe;
		
	}

	public EntityRecipe getRecipe() {
		return recipe;
	}
	
	
}
