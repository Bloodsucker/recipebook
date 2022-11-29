package com.jcabo.recipesapp.ingredients;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@RequiredArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @NonNull
    private String name;

    @NonNull
    private Boolean isVegetarian;

    @OneToMany(
            mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference("ingredient")
    private List<RecipesHasIngredients> recipesHasIngredientsList = new ArrayList<>();
}
