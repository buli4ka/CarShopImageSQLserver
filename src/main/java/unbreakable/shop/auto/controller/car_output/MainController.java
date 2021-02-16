package unbreakable.shop.auto.controller.car_output;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import unbreakable.shop.auto.entity.car_structure.Car;
import unbreakable.shop.auto.entity.car_structure.Image;
import unbreakable.shop.auto.service.CarService;
import unbreakable.shop.auto.service.ImageService;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private CarService carService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public String getAll(Model model){
        List<Car> cars = carService.getCars();
        List<Image> images = imageService.getImages();
        model.addAttribute("Cars", cars);
        model.addAttribute("Images", images);
        return "index";
    }

}
