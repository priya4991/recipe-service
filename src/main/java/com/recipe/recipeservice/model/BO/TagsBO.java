package com.recipe.recipeservice.model.BO;

import lombok.Data;

@Data
public class TagsBO {
    private String name;

    public TagsBO(String name) {
        this.name = name;
    }

}
