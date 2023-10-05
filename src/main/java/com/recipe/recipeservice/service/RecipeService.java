package com.recipe.recipeservice.service;

import com.recipe.recipeservice.model.Recipe;
import com.recipe.recipeservice.model.Tags;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipesByUserId(String userId);
    List<Tags> getAllTags();
}
