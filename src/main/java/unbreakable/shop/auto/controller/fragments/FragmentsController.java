package unbreakable.shop.auto.controller.fragments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {

    @GetMapping("/fragments")
    public String getHome() {
        return "fragments/fragments";
    }

    @GetMapping("/markup")
    public String markupPage() {
        return "fragments/markup";
    }

    @GetMapping("/params")
    public String paramsPage() {
        return "fragments/params";
    }

//    @GetMapping("/other")
//    public String otherPage(Model model) {
//        model.addAttribute("data", StudentUtils.buildStudents());
//        return "other.html";
//    }
}