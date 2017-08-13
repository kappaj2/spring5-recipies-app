package za.co.ajk.recipe.services;

import java.util.Set;

import za.co.ajk.recipe.commands.RecipeCommand;
import za.co.ajk.recipe.domain.Recipe;

public interface RecipeService {
    
    Set<Recipe> getRecipes();
    
    Recipe findById(Long l);
    
    RecipeCommand findCommandById(Long l);
    
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    
    void deleteById(Long idToDelete);
}