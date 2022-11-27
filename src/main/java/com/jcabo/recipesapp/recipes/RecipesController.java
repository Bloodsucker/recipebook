package com.jcabo.recipesapp.recipes;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

public class RecipesController {
    private final RecipesRepository recipesRepository;
    private final RecipesModelAssembler recipesModelAssembler;

    RecipesController(RecipesRepository repository, RecipesModelAssembler recipesModelAssembler) {
        this.recipesRepository = repository;
        this.recipesModelAssembler = recipesModelAssembler;
    }

    @GetMapping(path = "/")
    public CollectionModel<EntityModel<Recipe>> getAll() {
        return recipesModelAssembler.toCollectionModel(recipesRepository.findAll());
    }

    @GetMapping("/{id}")
    public EntityModel<Recipe> getById(@PathVariable Long id) {
        Recipe recipe = recipesRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));

        return recipesModelAssembler.toModel(recipe);
    }

    @PostMapping("/")
    public EntityModel<Recipe> create(@RequestBody Recipe newRecipe) {
        Recipe recipe = recipesRepository.save(newRecipe);

        return recipesModelAssembler.toModel(recipe);
    }
}
