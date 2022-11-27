package com.jcabo.recipesapp.recipes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RepositoryRestResource(collectionResourceRel = "recipes", path = "recipes")
interface RecipesRepository extends JpaRepository<Recipe, Long>, RecipesRepositoryCustom {


//    @Query("SELECT r FROM Recipe r WHERE r.vegetarian = :vegetarian")
//    List<Recipe> filter(boolean vegetarian, String description);
}
