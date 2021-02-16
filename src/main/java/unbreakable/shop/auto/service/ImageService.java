package unbreakable.shop.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import unbreakable.shop.auto.entity.car_structure.Car;
import unbreakable.shop.auto.entity.car_structure.Image;
import unbreakable.shop.auto.repository.ImageRepository;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(MultipartFile file, Car car){
        String imageName = file.getOriginalFilename();
        try {
            Image image = new Image();
            image.setCar(car);
            image.setImage(file.getBytes());
            image.setImageName(imageName);
            image.setImageType(file.getContentType());
            return imageRepository.save(image);
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

    public String getImgData(byte[] byteData) { return Base64.getMimeEncoder().encodeToString(byteData); }


}