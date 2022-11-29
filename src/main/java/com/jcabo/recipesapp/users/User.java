package com.jcabo.recipesapp.users;

import com.jcabo.recipesapp.recipes.Recipe;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "owner")
    private List<Recipe> ownedRecipes;

    @ManyToMany
    @JoinTable(
            name = "user_favourite_recipes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> favouriteRecipes;

    public List<Recipe> getOwnedRecipes() {
        return ownedRecipes;
    }
}
