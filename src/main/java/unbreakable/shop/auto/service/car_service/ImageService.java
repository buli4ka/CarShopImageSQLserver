package unbreakable.shop.auto.service.car_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import unbreakable.shop.auto.entity.car_structure.Car;
import unbreakable.shop.auto.entity.car_structure.Image;
import unbreakable.shop.auto.repository.car.ImageRepository;


import java.io.File;
import java.io.FileOutputStream;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Value("${image.path}")
    private String path;

    private static String generateString() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");
        return uuid;
    }

    private String fileRecordPath(byte[] fileBytes, String fileName){
        String path = "/resources/images/";
        System.out.println(path);
        try {
            path += fileName;
            this.path += path;
            File conFile = new File(this.path);
            if(conFile.createNewFile()){
            FileOutputStream fos = new FileOutputStream(conFile);
            fos.write(fileBytes);
            fos.close();}
        }
        catch (Exception e){e.printStackTrace();}



        return path;
    }

    public Image saveImage(MultipartFile file, Car car){
        String imageName = generateString() + file.getOriginalFilename();
        try {

            Image image = new Image();
            image.setCar(car);
            image.setImage(file.getBytes());
            image.setImageName(imageName);
            image.setImageType(file.getContentType());
            image.setImagePath(fileRecordPath(file.getBytes(),imageName));
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

    public Image getFirstImageByCarId(Integer carId){
        try {
            if(imageRepository.findFirstByCar_Id(carId) != null)
                return imageRepository.findFirstByCar_Id(carId);
        }
        catch (Exception e){e.printStackTrace();}

        return null;
    }

    public List<Image> getImages(){return imageRepository.findAll();}

    public String getImgData(byte[] byteData) { return Base64.getMimeEncoder().encodeToString(byteData); }

    public List<Image> getImagesByCarId(Integer id){
        return imageRepository.findAllByCar_Id(id);
    }


}