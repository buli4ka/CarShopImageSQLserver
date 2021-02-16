package unbreakable.shop.auto.controller.creating_controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import unbreakable.shop.auto.entity.car_structure.Manufacturer;

import unbreakable.shop.auto.service.ManufacturerService;

import java.util.List;

@Controller
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;


    @GetMapping("/admin/manufacturer")
    public String get(Model model){
        List<Manufacturer> manufacturers = manufacturerService.getManufacturers();
        model.addAttribute("Manufacturers",manufacturers);
        return "manufacturer";
    }

    @PostMapping("/admin/manufacturer/add")
    public String addManufacturer(@RequestParam("name") String manufacturerName){
        if(manufacturerService.getManufacturer(manufacturerName) == null)
            manufacturerService.saveManufacturer(manufacturerName);


        return "redirect:/admin/manufacturer";
    }
    @PostMapping("/admin/manufacturer/delete")
    public String deleteManufacturer(@RequestParam("name") String manufacturerName){
        manufacturerService.deleteManufacturer(manufacturerName);
        return "redirect:/admin/manufacturer";
    }
    @PostMapping("/admin/manufacturer/update")
    public String updateManufacturer(@RequestParam("name") String manufacturerName
            , @RequestParam("newName") String newManufacturerName ){
        manufacturerService.updateManufacturer(manufacturerName, newManufacturerName);
        return "redirect:/admin/manufacturer";
    }

}
