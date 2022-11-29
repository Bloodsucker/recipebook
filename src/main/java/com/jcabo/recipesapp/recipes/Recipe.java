package com.jcabo.recipesapp.recipes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jcabo.recipesapp.ingredients.RecipesHasIngredients;
import com.jcabo.recipesapp.users.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean vegetarian;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    @ManyToOne(optional = false)
    private User owner;

    @OneToMany(
            mappedBy = "recipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference("recipe")
    private List<RecipesHasIngredients> ingredients = new ArrayList<>();
}
