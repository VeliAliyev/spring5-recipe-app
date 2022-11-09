package guru.springframework.service.impl;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.converters.IngredientToIngredientCommand;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.repositories.IngredientRepository;
import guru.springframework.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public IngredientCommand findById(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow();
        IngredientToIngredientCommand converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        return converter.convert(ingredient);
    }
}
