package unbreakable.shop.auto.controller.car_output;


import org.apache.tomcat.jni.Directory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import unbreakable.shop.auto.entity.car_structure.Car;
import unbreakable.shop.auto.entity.car_structure.Image;
import unbreakable.shop.auto.service.CarService;
import unbreakable.shop.auto.service.ImageService;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class MainController {
    @Autowired
    private CarService carService;
    @Autowired
    private ImageService imageService;


    @GetMapping("/")
    public String getAll(Model model)  {
        List<Car> cars = carService.getCars();
        List<Image> images = new CopyOnWriteArrayList<>();
        for (Car car: cars ) {
            Image image = imageService.getFirstImageByCarId(car.getId());
            if(image != null){
                images.add(imageService.getFirstImageByCarId(car.getId()));
            }

        }
        model.addAttribute("Cars", cars);
        model.addAttribute("Images", images);
        return "index";
    }






}
