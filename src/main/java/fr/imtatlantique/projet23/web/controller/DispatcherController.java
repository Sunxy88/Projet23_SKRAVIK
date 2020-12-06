package fr.imtatlantique.projet23.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherController {

//    @RequestMapping("/index")
//    public String toIndex() {
//        return "index";
//    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/contact")
    public String toContact() {
        return "contact";
    }
}
