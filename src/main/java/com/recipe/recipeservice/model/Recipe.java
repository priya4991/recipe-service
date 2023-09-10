package com.recipe.recipeservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "recipes")
@Builder
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private String userId;
    private String title;
    private String subtitle;

    @Column(name = "hero_image")
    private String heroImage;
    private String content;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipes_tags", joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Tags> tags;

}
