package com.jcabo.recipesapp.recipes;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(Long id) {
        super("Could not find Recipe " + id);
    }
}
