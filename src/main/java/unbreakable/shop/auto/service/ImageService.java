package unbreakable.shop.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import unbreakable.shop.auto.entity.CarStructure.Image;
import unbreakable.shop.auto.repository.ImageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(MultipartFile file){
        String imageName = file.getOriginalFilename();
        try {
            Image imageModel = new Image(imageName
                    , file.getContentType()
                    , file.getBytes()
            );
            return imageRepository.save(imageModel);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Optional<Image> getImage(Integer imageId){
        return imageRepository.findById(imageId);
    }

    public List<Image> getImages(){return imageRepository.findAll();}
}