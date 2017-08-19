package za.co.ajk.recipe.services;

import za.co.ajk.recipe.commands.IngredientCommand;

public interface IngredientService {
    
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    
    void deleteById(Long recipeId, Long idToDelete);
}
