package com.jcabo.recipesapp.users;

import com.jcabo.recipesapp.recipes.Recipe;
import com.jcabo.recipesapp.recipes.RecipesModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UsersRepository usersRepository;
    private final UserModelAssembler userModelAssembler;

    private final RecipesModelAssembler recipesModelAssembler;

    public UserController(UsersRepository usersRepository, UserModelAssembler userModelAssembler, RecipesModelAssembler recipesModelAssembler) {
        this.usersRepository = usersRepository;
        this.userModelAssembler = userModelAssembler;
        this.recipesModelAssembler = recipesModelAssembler;
    }

    @PostMapping("/")
    EntityModel<User> newOne(@RequestBody User newUser) {
        User user = usersRepository.save(newUser);

        return userModelAssembler.toModel(user);
    }

    @GetMapping("/{id}")
    public EntityModel<User> getById(@PathVariable Long id) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return userModelAssembler.toModel(user);
    }

    @GetMapping("/{id}/ownedRecipes/")
    public CollectionModel<EntityModel<Recipe>> ownedRecipes(@PathVariable Long id) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return recipesModelAssembler.toCollectionModel(user.getOwnedRecipes())
                .add(linkTo(methodOn(UserController.class).ownedRecipes(user.getId())).withSelfRel());
    }
}
