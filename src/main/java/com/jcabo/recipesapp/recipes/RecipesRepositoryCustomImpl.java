package com.jcabo.recipesapp.recipes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class RecipesRepositoryCustomImpl implements RecipesRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Recipe> filter(Boolean vegetarian, String withInstructions, String withIngredients, String includeIngredients, String excludeIngredients) {
        List<String> conjunctionPredicates = new ArrayList<>();

        if (vegetarian != null) {
            conjunctionPredicates.add(String.format("r.vegetarian IS %s", vegetarian ? "TRUE" : "NOT TRUE"));
        }

        if(withInstructions != null) {
            for (String wordInInstructions : withInstructions.split(",")) {
                conjunctionPredicates.add(String.format("r.instructions LIKE '%%%s%%'", wordInInstructions));
            }
        }

        if(includeIngredients != null) {
            List<String> includeIngredientsPredicates = new ArrayList<>();
            for (String includeIngredient : includeIngredients.split(",")) {
                includeIngredientsPredicates.add(String.format("i.name LIKE '%s'", includeIngredient));
            }

            String includeIngredientsJql = String.join(" OR ", includeIngredientsPredicates);

            String jql = "r.id IN (SELECT rhi.recipe.id FROM RecipesHasIngredients rhi JOIN Ingredient i ON rhi.ingredient.id = i.id" +
                    " WHERE rhi.recipe.id = r.id AND (" + includeIngredientsJql + ")" +
                    " GROUP BY rhi.recipe.id " +
                    " HAVING count(distinct rhi.ingredient.id) = " + includeIngredientsPredicates.size() +
                    ")";

            conjunctionPredicates.add(jql);
        }

        if(excludeIngredients != null) {
            List<String> predicates = new ArrayList<>();
            for (String includeIngredient : excludeIngredients.split(",")) {
                predicates.add(String.format("i.name LIKE '%s'", includeIngredient));
            }

            String disjunctionJql = String.join(" OR ", predicates);

            String jql = "r.id NOT IN (SELECT rhi.recipe.id FROM RecipesHasIngredients rhi JOIN Ingredient i ON rhi.ingredient.id = i.id" +
                    " WHERE rhi.recipe.id = r.id AND (" + disjunctionJql + ")" +
                    " GROUP BY rhi.recipe.id " +
                    " HAVING count(distinct rhi.ingredient.id) = " + predicates.size() +
                    ")";

            conjunctionPredicates.add(jql);
        }

        String jql = "SELECT r FROM Recipe r";

        if(conjunctionPredicates.size() > 0) {
            jql += " WHERE " + String.join(" AND ", conjunctionPredicates);
        }

        return entityManager.createQuery(jql, Recipe.class).getResultList();
    }
}
