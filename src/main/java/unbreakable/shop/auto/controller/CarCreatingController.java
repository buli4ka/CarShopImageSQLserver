package unbreakable.shop.auto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import unbreakable.shop.auto.entity.CarStructure.Car;
import unbreakable.shop.auto.service.BodyTypeService;
import unbreakable.shop.auto.service.CarModelService;
import unbreakable.shop.auto.service.CreatingCarService;
import unbreakable.shop.auto.service.ManufacturerService;

import java.util.List;

@Controller
public class CarCreatingController {
    @Autowired
    private CreatingCarService creatingCarService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private BodyTypeService bodyTypeService;
    @Autowired
    private CarModelService carModelService;

    @GetMapping("/admin/car")
    public String get(Model model) {
        List<Car> cars = creatingCarService.getCars();
        model.addAttribute("Cars", cars);
        return "car";
    }

    @PostMapping("/admin/car/add")
    public String addCar(@RequestParam("manufacturer") String manufacturerName
            , @RequestParam("carModel") String carModelName
            , @RequestParam("yearOfIssue") short yearOfIssue
            , @RequestParam("bodyType") String bodyTypeName
            , @RequestParam("carDescription") String carDescription
            , @RequestParam("price") double price) {
        creatingCarService.saveCar(price
                , manufacturerService.getManufacturer(manufacturerName)
                , bodyTypeService.getBodyType(bodyTypeName)
                , yearOfIssue, carModelService.getCarModel(carModelName)
                , carDescription);
        return "redirect:/admin/car";
    }


}
