package guru.springframework.service.impl;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.repositories.IngredientRepository;
import guru.springframework.service.IngredientService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {

    @Mock
    private IngredientRepository ingredientRepository;

    IngredientService ingredientService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ingredientService = new IngredientServiceImpl(ingredientRepository);
    }

    @Test
    public void findById() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        when(ingredientRepository.findById(any(Long.class))).thenReturn(Optional.of(ingredient));

        //when
        IngredientCommand ingredientCommand = ingredientService.findById(1L);

        //then
        assertEquals((long) ingredientCommand.getId(), 1L);
        verify(ingredientRepository, times(1)).findById(any(Long.class));
    }
}