package unbreakable.shop.auto.controller.car_output;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import unbreakable.shop.auto.entity.car_structure.Car;
import unbreakable.shop.auto.entity.car_structure.Image;
import unbreakable.shop.auto.service.CarService;
import unbreakable.shop.auto.service.ImageService;

import java.util.List;
import java.util.Optional;

@Controller
public class CarInfoController {
    @Autowired
    private CarService carService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/{id}")
    public String get(@PathVariable("id") Integer id, Model model){
        Optional<Car> car = carService.getCar(id);
        List<Image> images = imageService.getImagesByCarId(id);
        model.addAttribute("Car", car);
        model.addAttribute("Images", images);

        return "carInfo";
    }

}
