package com.example.RecipeManagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository<EntityIngredient, Long> {

}
