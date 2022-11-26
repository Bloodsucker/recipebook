package com.jcabo.recipesapp.users;

import com.jcabo.recipesapp.recipes.Recipe;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UsersRepository usersRepository;
    private final UserModelAssembler userModelAssembler;

    public UserController(UsersRepository usersRepository, UserModelAssembler userModelAssembler) {
        this.usersRepository = usersRepository;
        this.userModelAssembler = userModelAssembler;
    }

    @PostMapping("/")
    User newOne(@RequestBody User newUser) {
        return usersRepository.save(newUser);
    }

    @GetMapping("/{id}")
    public EntityModel<User> getById(@PathVariable Long id) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return userModelAssembler.toModel(user);
    }

    @GetMapping("/recipes/")
    public EntityModel<Recipe> ownedRecipes() {
        return null;
    }
}
