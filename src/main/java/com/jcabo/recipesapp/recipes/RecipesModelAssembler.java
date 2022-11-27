package com.jcabo.recipesapp.recipes;

import com.jcabo.recipesapp.users.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RecipesModelAssembler implements RepresentationModelAssembler<Recipe, EntityModel<Recipe>> {

    @Override
    public EntityModel<Recipe> toModel(Recipe recipe) {
        return EntityModel.of(recipe,
                linkTo(methodOn(RecipesController.class).getById(recipe.getId())).withSelfRel(),
                linkTo(methodOn(RecipesController.class).getAll()).withRel("recipes"),
                linkTo(methodOn(UserController.class).getById(recipe.getOwner().getId())).withRel("owner"));
    }
}
