package guru.springframework.controllers;

import guru.springframework.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final RecipeService recipeService;

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
