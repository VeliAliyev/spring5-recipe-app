package guru.springframework.controllers;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.service.IngredientService;
import guru.springframework.service.RecipeService;
import guru.springframework.service.impl.IngredientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(Model model, @PathVariable Long recipeId){
        RecipeCommand recipeCommand = recipeService.findCommandById(recipeId);
        model.addAttribute("recipe", recipeCommand);
        return "recipe/ingredient/list";
    }

    @GetMapping("/ingredient/{ingredientId}")
    public String showRecipeIngredient(Model model,@PathVariable Long ingredientId){
        IngredientCommand ingredientCommand = ingredientService.findById(ingredientId);
        model.addAttribute("ingredient", ingredientCommand);
        return "recipe/ingredient/show";
    }
}
