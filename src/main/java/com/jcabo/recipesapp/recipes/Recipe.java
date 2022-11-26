package com.jcabo.recipesapp.recipes;

import com.fasterxml.jackson.annotation.*;
import com.jcabo.recipesapp.users.User;

import javax.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean vegetarian;
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "fk_recipe_owner"))
    @JsonBackReference
    private User owner;
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    Recipe(boolean vegetarian, String description) {
        this.vegetarian = vegetarian;
        this.description = description;
    }

    protected Recipe() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
