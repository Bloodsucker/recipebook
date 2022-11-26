package com.jcabo.recipesapp.recipes;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(path="/recipes")
public class RecipesController {
    private final RecipesRepository recipesRepository;
    private final RecipesModelAssembler recipesModelAssembler;

    RecipesController(RecipesRepository repository, RecipesModelAssembler recipesModelAssembler) {
        this.recipesRepository = repository;
        this.recipesModelAssembler = recipesModelAssembler;
    }

    @GetMapping(path = "/")
    public CollectionModel<EntityModel<Recipe>> all() {
        return recipesModelAssembler.toCollectionModel(recipesRepository.findAll());
    }

    @GetMapping("/{id}")
    EntityModel<Recipe> one(@PathVariable Long id) {
        Recipe recipe = recipesRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));

        return recipesModelAssembler.toModel(recipe);
    }

    @PostMapping("/")
    Recipe newOne(@RequestBody Recipe newRecipe) {
        return recipesRepository.save(newRecipe);
    }
}
