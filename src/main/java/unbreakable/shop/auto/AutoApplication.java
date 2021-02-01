package unbreakable.shop.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import unbreakable.shop.auto.entity.Image;
import unbreakable.shop.auto.repository.ImageRepository;

import java.util.List;

@SpringBootApplication
public class AutoApplication  {



	public static void main(String[] args) {
		SpringApplication.run(AutoApplication.class, args);
	}



}
