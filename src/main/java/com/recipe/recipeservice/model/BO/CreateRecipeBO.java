package com.recipe.recipeservice.model.BO;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
@Builder
public class CreateRecipeBO {
    @NonNull
    private String userId;
    @NonNull
    private String title;
    private String subtitle;
    @NonNull
    private String heroImage;
    @NonNull
    private String content;
    @NonNull
    private Set<TagsBO> tags;
}
