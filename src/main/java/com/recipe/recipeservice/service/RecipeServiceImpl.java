package com.recipe.recipeservice.service;

import com.recipe.recipeservice.model.BO.CreateRecipeBO;
import com.recipe.recipeservice.model.BO.TagsBO;
import com.recipe.recipeservice.model.Recipe;
import com.recipe.recipeservice.model.Tags;
import com.recipe.recipeservice.repository.RecipeRepository;
import com.recipe.recipeservice.repository.TagsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public void createRecipe(CreateRecipeBO recipeBO) {
        Set<Tags> tags = new HashSet<>();
        for (TagsBO tag : recipeBO.getTags()) {
            tags.add(new Tags(tag.getName()));
        }
        Recipe recipe = Recipe.builder()
                .title(recipeBO.getTitle())
                .content(recipeBO.getContent())
                .heroImage(recipeBO.getHeroImage())
                .subtitle(recipeBO.getSubtitle())
                .tags(tags)
                .userId(recipeBO.getUserId())
                .build();

        recipeRepository.save(recipe);
    }
}
