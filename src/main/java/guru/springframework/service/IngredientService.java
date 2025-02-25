package guru.springframework.service;

import guru.springframework.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveOrUpdate(IngredientCommand ingredientCommand);
    void deleteIngredient(Long id, Long aLong);
}
