package com.recipe.recipeservice.service;

import com.recipe.recipeservice.model.Recipe;
import com.recipe.recipeservice.model.Tags;
import com.recipe.recipeservice.repository.RecipeRepository;
import com.recipe.recipeservice.repository.TagsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService{
    private RecipeRepository recipeRepository;
    private TagsRepository tagsRepository;
    @Override
    public List<Recipe> getRecipesByUserId(String userId) {
        return recipeRepository.findAllByUserId(userId);
    }

    @Override
    public List<Tags> getAllTags() {
        return tagsRepository.findAll();
    }
}
