package com.jcabo.recipesapp.recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jcabo.recipesapp.ingredients.Ingredient;
import com.jcabo.recipesapp.ingredients.RecipesHasIngredients;
import com.jcabo.recipesapp.users.User;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean vegetarian;
    private String description;

    @ManyToOne(optional = false)
    private User owner;

    @OneToMany(
            mappedBy = "recipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RecipesHasIngredients> ingredients = new ArrayList<>();
}
