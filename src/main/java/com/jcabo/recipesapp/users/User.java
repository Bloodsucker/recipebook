package com.jcabo.recipesapp.users;

import com.fasterxml.jackson.annotation.*;
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
    @JsonIgnore
    private List<Recipe> ownedRecipes;

    public List<Recipe> getOwnedRecipes() {
        return ownedRecipes;
    }
}
