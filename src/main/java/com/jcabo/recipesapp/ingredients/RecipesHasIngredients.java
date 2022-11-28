package com.jcabo.recipesapp.ingredients;

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
    private RecipesHasIngredientsId id;

    @ManyToOne
    @MapsId("recipeId")
    private Recipe recipe = new Recipe();

    @ManyToOne
    @MapsId("ingredientId")
    private Ingredient ingredient = new Ingredient();

    @Column(name = "amount")
    private String amount;
}
