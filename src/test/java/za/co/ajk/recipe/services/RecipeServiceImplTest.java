package za.co.ajk.recipe.services;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import za.co.ajk.recipe.converters.RecipeCommandToRecipe;
import za.co.ajk.recipe.converters.RecipeToRecipeCommand;
import za.co.ajk.recipe.domain.Recipe;
import za.co.ajk.recipe.repositories.RecipeRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Pure JUnit test as no Spring context instantiated or outside api called.
 */
public class RecipeServiceImplTest {
    
    RecipeServiceImpl recipeService;
    
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }
    
    @Test
    public void getRecipes() throws Exception {
    
        Recipe recipe = new Recipe();
        Set recipesData = new HashSet();
        recipesData.add(recipe);
        
        when(recipeService.getRecipes()).thenReturn(recipesData);
        
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        
        //  Verify findAll() method called once.
        Mockito.verify(recipeRepository, times(1)).findAll();
    }
    
}