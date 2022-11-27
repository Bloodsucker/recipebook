package com.jcabo.recipesapp.recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jcabo.recipesapp.users.User;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean vegetarian;
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "fk_recipe_owner"))
    @JsonIgnore
    private User owner;

    Recipe(boolean vegetarian, String description) {
        this.vegetarian = vegetarian;
        this.description = description;
    }
}
