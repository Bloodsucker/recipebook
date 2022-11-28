package com.jcabo.recipesapp.ingredients;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class RecipesHasIngredientsId implements Serializable {
    private Long recipeId;

    private Long ingredientId;
}
