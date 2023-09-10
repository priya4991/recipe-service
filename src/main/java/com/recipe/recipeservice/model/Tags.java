package com.recipe.recipeservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Recipe> recipes;

    public Tags(String name) {
        this.name = name;
    }
}
