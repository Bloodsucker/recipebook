package com.jcabo.recipesapp.recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jcabo.recipesapp.users.User;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "fk_recipe_owner"))
    private User owner;

    Recipe(boolean vegetarian, String description) {
        this.vegetarian = vegetarian;
        this.description = description;
    }
}
