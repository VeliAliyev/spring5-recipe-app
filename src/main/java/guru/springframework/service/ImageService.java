package guru.springframework.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface ImageService {
    void saveImageFile(Long id, MultipartFile file) throws IOException;
}
