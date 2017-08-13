package za.co.ajk.recipe.controllers;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import za.co.ajk.recipe.domain.Recipe;
import za.co.ajk.recipe.services.RecipeService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class IndexController_FixtureBasedTest {
    
    private Fixture fixture;
    
    @Before
    public void setUp() throws Exception {
        fixture = new Fixture();
    }
    
    @Test
    public void testIndexPageFunctionsOnController() {
        
        int setInControllerSize = 2;
        int getRecipeCallSize = 1;
        int calledTimes = 1;
        
        fixture.givenRecipeSourceIsSet();
        fixture.whenRecipeServiceGetRecipesIsCalled();
        fixture.thenReturnedStringIs("index");
        fixture.thenRecipeServiceGetRecipeIsCalledTimes(getRecipeCallSize);
        fixture.thenInControllerSizeMustBe(setInControllerSize);
        fixture.testThatModelSetAttributeSetCalledTimes(calledTimes);
    }
    
    /**
     * Private class than helps with Give/When/Then Fixture testing methodology.
     */
    private class Fixture {
        
        private Set<Recipe> sourceSet;
        
        @Mock
        private RecipeService recipeService;
        
        @Mock
        Model model;
        
        private IndexController indexController;
        
        public Fixture() throws Exception {
            MockitoAnnotations.initMocks(this);
            indexController = new IndexController(recipeService);
        }
    
        /**
         * Setup test data to be used.
         */
        private void givenRecipeSourceIsSet() {
            
            sourceSet = new HashSet<>();
            Recipe recipe1 = new Recipe();
            Recipe recipe2 = new Recipe();
            recipe1.setId(1L);
            recipe2.setId(2L);
            
            sourceSet.add(recipe1);
            sourceSet.add(recipe2);
        }
    
        /**
         * The the getRecipes method is called then return the Object created for testing.
         */
        private void whenRecipeServiceGetRecipesIsCalled() {
            
            when(recipeService.getRecipes()).thenReturn(sourceSet);
        }
    
        /**
         * Return String value must match the input value 
         * @param resultString
         */
        private void thenReturnedStringIs(String resultString) {
            
            assertEquals(resultString, indexController.getIndexPage(model));
        }
        
        /**
         * Test that RecipeService.getRecipes() should have be called once.
         *
         * @param calledTimes
         */
        private void thenRecipeServiceGetRecipeIsCalledTimes(int calledTimes) {
            
            Mockito.verify(recipeService, times(calledTimes)).getRecipes();
        }
        
        /**
         * Model.setAttribute should have be called once. Adding a Set with key "recipes". Note eq...
         *
         * @param setSize
         */
        private void thenInControllerSizeMustBe(int setSize) {
            
            ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
            Mockito.verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
            Set<Recipe> setInController = argumentCaptor.getValue();
            assertEquals(setSize, setInController.size());
        }
        
        /**
         * Verify that the addAttributes method called so many times.
         *
         * @param calledTimes
         */
        private void testThatModelSetAttributeSetCalledTimes(int calledTimes) {
            ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
            Mockito.verify(model, times(calledTimes)).addAttribute(eq("recipes"), argumentCaptor.capture());
        }
    }
}

