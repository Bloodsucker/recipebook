package com.jcabo.recipesapp.recipes;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "recipes", path = "recipes")
interface RecipesRepository extends PagingAndSortingRepository<Recipe, Long> {
    List<Recipe> findByVegetarian(boolean vegetarian);
}
