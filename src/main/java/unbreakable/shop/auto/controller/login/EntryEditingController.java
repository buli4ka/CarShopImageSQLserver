package unbreakable.shop.auto.controller.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EntryEditingController {

    @GetMapping("/admin")
    public String get() {
        //if(userService.getAccess(name,password))
            return "entryForAdmins";
        //else return "goAway";
    }

    @PostMapping("/admin/logout")
    public String logout(){
        return "redirect: /";
    }


}
