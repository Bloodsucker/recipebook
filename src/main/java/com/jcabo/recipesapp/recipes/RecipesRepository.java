package com.jcabo.recipesapp.recipes;


import org.springframework.data.repository.CrudRepository;

interface RecipesRepository extends CrudRepository<Recipe, Long> {

}
