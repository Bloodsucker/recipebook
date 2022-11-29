package com.jcabo.recipesapp.ingredients;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jcabo.recipesapp.recipes.Recipe;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter@RequiredArgsConstructor
@Table(name = "recipes_has_ingredients")
public class RecipesHasIngredients {
    @EmbeddedId
    private RecipesHasIngredientsId id = new RecipesHasIngredientsId();

    @ManyToOne
    @MapsId("recipeId")
    @JsonBackReference("recipe")
    private Recipe recipe = new Recipe();

    @ManyToOne
    @MapsId("ingredientId")
    @JsonBackReference("ingredient")
    private Ingredient ingredient = new Ingredient();

    @Column(name = "amount")
    private String amount;
}
