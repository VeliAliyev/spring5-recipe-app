package guru.springframework.service.impl;


import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.service.RecipeService;
import guru.springframework.service.impl.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;


import java.util.ArrayList;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;


    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeList);

        assertEquals(1, recipeService.getRecipes().size());
        verify(recipeRepository, times(1)).findAll();
    }
}