package unbreakable.shop.auto.controller.creating_controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import unbreakable.shop.auto.service.CarModelService;


@Controller
public class EntryEditingController {

    @GetMapping("/admin")
    public String get() {
        //if(userService.getAccess(name,password))
            return "entryForAdmins";
        //else return "goAway";
    }


}
