package unbreakable.shop.auto.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import unbreakable.shop.auto.entity.Image;
import unbreakable.shop.auto.repository.ImageRepository;

import javax.persistence.Entity;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {
    private final ImageRepository imageRepository;

    public Bootstrap(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Srarted in Bootstrap");
        Image image = new Image();
        image.setImageName("ImageName");
        image.setImageType("jpg");
        image.setImagePath("C:\\Users\\ImageName.jpg");
        imageRepository.save(image);
        System.out.println("Image count: " + imageRepository.count());

    }
}
