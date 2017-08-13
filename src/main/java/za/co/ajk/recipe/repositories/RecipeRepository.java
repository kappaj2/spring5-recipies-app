package za.co.ajk.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import za.co.ajk.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    
}
