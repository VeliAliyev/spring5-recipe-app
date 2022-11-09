package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IngredientController {

    private final RecipeService recipeService;

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(Model model, @PathVariable Long recipeId){
        RecipeCommand recipeCommand = recipeService.findCommandById(recipeId);
        model.addAttribute("recipe", recipeCommand);
        return "recipe/ingredient/list";
    }

}
