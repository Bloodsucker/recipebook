package com.jcabo.recipesapp.ingredients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ingredients", path = "ingredients")
public interface IngredientsRepository  extends JpaRepository<Ingredient, Long> {
}
