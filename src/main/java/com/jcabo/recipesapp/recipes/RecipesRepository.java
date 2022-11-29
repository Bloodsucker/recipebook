package com.jcabo.recipesapp.recipes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "recipes", path = "recipes")
public interface RecipesRepository extends JpaRepository<Recipe, Long>, RecipesRepositoryCustom {


//    @Query("SELECT r FROM Recipe r WHERE r.vegetarian = :vegetarian")
//    List<Recipe> filter(boolean vegetarian, String description);
}
