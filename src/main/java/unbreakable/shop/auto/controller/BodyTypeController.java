package unbreakable.shop.auto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import unbreakable.shop.auto.entity.CarStructure.BodyType;
import unbreakable.shop.auto.service.BodyTypeService;

import java.util.List;

@Controller
public class BodyTypeController {
    @Autowired
    private BodyTypeService bodyTypeService;

    @GetMapping("/admin/bodyType")
    public String get(Model model){
        List<BodyType> bodyTypes = bodyTypeService.getBodyTypes();
        model.addAttribute("BodyTypes",bodyTypes);
        return "bodyType";
    }
    @PostMapping("/admin/bodyType/add")
    public String addBodyType(@RequestParam("name") String bodyTypeName){
        if(bodyTypeService.getBodyType(bodyTypeName) == null)
            bodyTypeService.saveBodyType(bodyTypeName);
        return "redirect:/admin/bodyType";
    }
    @PostMapping("/admin/bodyType/delete")
    public String deleteBodyType(@RequestParam("name") String bodyTypeName){
        bodyTypeService.deleteBodyType(bodyTypeName);
        return "redirect:/admin/bodyType";
    }
    @PostMapping("/admin/bodyType/update")
    public String updateBodyType(@RequestParam("name") String bodyTypeName
            , @RequestParam("newName") String newBodyTypeName){
        bodyTypeService.updateManufacturer(bodyTypeName,newBodyTypeName);
        return "redirect:/admin/bodyType";
    }



}
