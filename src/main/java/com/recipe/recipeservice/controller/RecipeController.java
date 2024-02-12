package com.recipe.recipeservice.controller;

import com.recipe.recipeservice.model.BO.CreateRecipeBO;
import com.recipe.recipeservice.model.Recipe;
import com.recipe.recipeservice.model.Tags;
import com.recipe.recipeservice.repository.RecipeRepository;
import com.recipe.recipeservice.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe/management")
@AllArgsConstructor
public class RecipeController {
    private RecipeService recipeService;
    @GetMapping("/get-recipe/{userid}")
    public ResponseEntity<List<Recipe>> getRecipesByUserId(@PathVariable(name = "userid") String id) {
        List<Recipe> recipes = recipeService.getRecipesByUserId(id);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @PostMapping("/create-recipe/{userid}")
    public ResponseEntity<String> createRecipe(@PathVariable(name = "userid") String id,
                                          @RequestBody CreateRecipeBO recipe) {
        recipeService.createRecipe(recipe);
        return new ResponseEntity<>("Recipe added", HttpStatus.CREATED);

    }

    @GetMapping("/get-tags")
    public ResponseEntity<List<Tags>> getAllTags() {
        List<Tags> tags = recipeService.getAllTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }
}
