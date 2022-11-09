package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @RequestMapping("recipe/{id}/show")
    public String getRecipeById(Model model, @PathVariable Long id){
        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipe", recipe);
        return "recipe/show";
    }

    @RequestMapping("recipe/{id}/update")
    public String updateRecipeById(Model model, @PathVariable Long id){
        RecipeCommand recipeCommand = recipeService.findCommandById(id);
        model.addAttribute("recipe", recipeCommand);
        return "recipe/recipeForm";
    }

    @RequestMapping("recipe/{id}/delete")
    public String delete(Model model, @PathVariable Long id){
        recipeService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeForm";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }
}
