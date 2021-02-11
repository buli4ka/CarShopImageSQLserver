package unbreakable.shop.auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import unbreakable.shop.auto.entity.CarStructure.CarModel;
import unbreakable.shop.auto.entity.CarStructure.Manufacturer;
import unbreakable.shop.auto.service.CarModelService;
import unbreakable.shop.auto.service.ManufacturerService;

import java.util.List;

@Controller
public class CarModelController {
    @Autowired
    private CarModelService carModelService;
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/admin/carModel")
    public String get(Model model){
        List<CarModel> carModels = carModelService.getCarModels();
        List<Manufacturer> manufacturers = manufacturerService.getManufacturers();
        model.addAttribute("CarModels", carModels);
        model.addAttribute("Manufacturers", manufacturers);
        return "carModel";
    }

    @PostMapping("/admin/carModel/add")
    public String addCarModel(@RequestParam("carModelName") String carModelName
            , @RequestParam("name") String manufacturerName ){
        if(manufacturerService.getManufacturer(manufacturerName) != null)
            carModelService.saveCarModel(carModelName
                , manufacturerService.getManufacturer(manufacturerName));
        else{
            manufacturerService.saveManufacturer(manufacturerName);
            carModelService.saveCarModel(carModelName
                    , manufacturerService.getManufacturer(manufacturerName));
        }

        return "redirect:/admin/carModel";
    }

    @PostMapping("/admin/carModel/delete")
    public String deleteCarModel(@RequestParam("name") String carModelName){
        carModelService.deleteCarModel(carModelName);
        return "redirect:/admin/carModel";
    }
    @PostMapping("/admin/carModel/update")
    public String updateCarModel(@RequestParam("name") String carModelName
            , @RequestParam("newName") String newcarModelName){
        carModelService.updateCarModel(carModelName,newcarModelName);
        return "redirect:/admin/carModel";
    }

}
