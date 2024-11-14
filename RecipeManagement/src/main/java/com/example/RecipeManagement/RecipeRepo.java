package com.example.RecipeManagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<EntityRecipe, Long> {

}
