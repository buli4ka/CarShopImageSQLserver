package unbreakable.shop.auto.bootstrap;

import org.springframework.stereotype.Component;
import unbreakable.shop.auto.repository.ImageRepository;

@Component
public class Bootstrap /*implements CommandLineRunner*/ {
    private final ImageRepository imageRepository;

    public Bootstrap(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    /*@Override
    public void run(String... args) throws Exception {
        System.out.println("Srarted in Bootstrap");
        Image image = new Image();
        image.setImageName("ImageName");
        image.setImageType("jpg");
        //todo image.setImage("C:\\Users\\ImageName.jpg");
        imageRepository.save(image);
        System.out.println("Image count: " + imageRepository.count());

    }*/
}
