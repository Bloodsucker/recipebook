package com.jcabo.recipesapp.recipes;

import java.util.List;

public interface RecipesRepositoryCustom {
    List<Recipe> custom(Boolean vegetarian, String description);
}
