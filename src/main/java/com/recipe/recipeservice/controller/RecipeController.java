package com.recipe.recipeservice.controller;

import com.recipe.recipeservice.model.Recipe;
import com.recipe.recipeservice.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipe/management")
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;
    @GetMapping("/getrecipe/{userid}")
    public ResponseEntity<List<Recipe>> getRecipesByUserId(@PathVariable(name = "userid") String id) {
        List<Recipe> recipes = recipeRepository.findAllByUserId(id);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
}
