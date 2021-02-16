package unbreakable.shop.auto.controller.creating_controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import unbreakable.shop.auto.service.CarModelService;

@Controller
public class EntryEditingController {

    @GetMapping("/admin")
    public String get() {
        return "entryForAdmins";
    }


}
