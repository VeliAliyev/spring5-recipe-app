package guru.springframework.service;

import guru.springframework.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findById(Long id);
}
