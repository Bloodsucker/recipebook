package com.jcabo.recipesapp.recipes;

import java.util.List;

public interface RecipesRepositoryCustom {
    List<Recipe> filter(Boolean vegetarian, String withInstructions, String withIngredients, String includeIngredients, String excludeIngredients);
}
