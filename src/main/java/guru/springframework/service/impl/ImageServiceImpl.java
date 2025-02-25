package guru.springframework.service.impl;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow();
        try {
            Byte[] byteObjects  = new Byte[file.getBytes().length];
            int i = 0;

            for(byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);
        } catch (IOException e) {
            log.error("Error occured : ", e);
            e.printStackTrace();
        }
    }
}
