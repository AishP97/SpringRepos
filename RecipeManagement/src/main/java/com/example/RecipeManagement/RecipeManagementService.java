package com.example.RecipeManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class RecipeManagementService {
	
	@Autowired
	private RecipeRepo reciperepo;
	
	@Autowired
	private IngredientRepo indrepo;
	
	public EntityRecipe createRecipe(EntityRecipe recipe) {
		return reciperepo.save(recipe);
	}
		
	
	public List<EntityRecipe> getAllRecipes(){
		return reciperepo.findAll();
		
	}
	
	public EntityRecipe getRecipeById(Long id) {
		return reciperepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));		
	}
	
	
	@Transactional
	public EntityIngredient addIngredient(Long recipeid, EntityIngredient ind) {
		EntityRecipe recipe = getRecipeById(recipeid);
		boolean isDuplicate = recipe.getIngredients().stream().anyMatch(existingIngredient -> existingIngredient.
				getName().equalsIgnoreCase(ind.getName()));
		if(isDuplicate) {
			throw new IllegalArgumentException("Ingredient already exists");
		}
		
		ind.setRecipe(recipe);
		recipe.addIngredient(ind);
		reciperepo.save(recipe); 
		return ind;
				//indrepo.save(ind);
	}
	
	public void removeIngredient(Long ingredientid,Long recipeid) {
		EntityRecipe recipe = reciperepo.findById(recipeid)
	            .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));

	    EntityIngredient ingredient = indrepo.findById(ingredientid)
	            .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));

	    recipe.getIngredients().remove(ingredient);
	    indrepo.deleteById(ingredientid);
	    reciperepo.save(recipe);
	//	indrepo.deleteById(ingredientid);
	}

}
