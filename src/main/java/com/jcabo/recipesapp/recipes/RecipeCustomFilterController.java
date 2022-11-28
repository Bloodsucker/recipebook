package com.jcabo.recipesapp.recipes;

import com.jcabo.recipesapp.ingredients.RecipesHasIngredients;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//@RepositoryRestController(path = "recipes")
//@RequiredArgsConstructor
public class RecipeCustomFilterController {
//    private final RecipesRepository recipesRepository;

//    @PostMapping("/:id/ingredients")
//    @ResponseBody
//    public void ingredients(String id) {
//        System.out.println("recipesHasIngredients");
//    }
//
//    @PostMapping(path = "/{id}/ingredients",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    @ResponseBody
//    public ResponseEntity<?> filter(@PathVariable Long id, @RequestBody){
////        Iterable<Recipe> recipes = recipesRepository.findAll();
////
////        CollectionModel<EntityModel<Recipe>> resources = CollectionModel.wrap(recipes);
////        resources.add(linkTo(methodOn(RecipeCustomFilterController.class).filter()).withSelfRel());
////
////        return ResponseEntity.ok(resources);
//
//        return null;
//    }
}
