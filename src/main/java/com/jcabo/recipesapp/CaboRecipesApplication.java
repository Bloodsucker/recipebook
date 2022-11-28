package com.jcabo.recipesapp;

import com.jcabo.recipesapp.ingredients.Ingredient;
import com.jcabo.recipesapp.ingredients.IngredientsRepository;
import com.jcabo.recipesapp.ingredients.RecipesHasIngredients;
import com.jcabo.recipesapp.recipes.Recipe;
import com.jcabo.recipesapp.recipes.RecipesRepository;
import com.jcabo.recipesapp.users.User;
import com.jcabo.recipesapp.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories
public class CaboRecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaboRecipesApplication.class, args);
	}

//	@Autowired
//	private UsersRepository usersRepository;
//	@Autowired
//	private RecipesRepository recipesRepository;
//	@Autowired
//	private IngredientsRepository ingredientsRepository;

//	@PostConstruct
//	void checkitOut() {
//		User user = usersRepository.findById(1L).orElseThrow(RuntimeException::new);
//
//		Recipe recipe = new Recipe();
//		recipe.setOwner(user);
//		recipe.setDescription("Something");
//		recipe.setVegetarian(false);
//
//		Ingredient ingredient = new Ingredient();
//		ingredient.setName("Chicken");
//		ingredient.setIsVegetarian(false);
//
//		RecipesHasIngredients recipesHasIngredients = new RecipesHasIngredients();
//		recipesHasIngredients.setAmount("2 kg");
//		recipesHasIngredients.setRecipe(recipe);
//		recipesHasIngredients.setIngredient(ingredient);
//
//		recipe.getIngredients().add(recipesHasIngredients);
//
//		recipesRepository.save(recipe);
//	}

}
