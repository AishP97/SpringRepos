package com.example.RecipeManagement;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/recipes")
public class RecipeManagementController {
	
	@Autowired
	private RecipeManagementService recipeservice;
	
	@PostMapping
	public ResponseEntity<EntityRecipe> createRecipe(@RequestBody EntityRecipe recipe){
		EntityRecipe createdRecipe = recipeservice.createRecipe(recipe);
		return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<EntityRecipe> getAllRecipes(){
		
		return recipeservice.getAllRecipes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntityRecipe> getRecipeById(@PathVariable Long id){
		EntityRecipe recipe = recipeservice.getRecipeById(id);
		return ResponseEntity.ok(recipe);
	}
	
	@PostMapping("/{id}/ingredients")
	public ResponseEntity<EntityIngredient> addIngredient(@PathVariable Long id, @RequestBody EntityIngredient ind){
		EntityIngredient addedIngredient = recipeservice.addIngredient(id, ind);
		return new ResponseEntity<>(addedIngredient,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{recipeid}/ingredients/{ingredientid}")
	public ResponseEntity<Void> removeIngredient(@PathVariable Long recipeid, @PathVariable Long ingredientid){
		recipeservice.removeIngredient(recipeid,ingredientid);
		return ResponseEntity.noContent().build() ;
		
	}
		
	

}
