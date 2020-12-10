package fr.imtatlantique.projet23.web.controller;

import fr.imtatlantique.projet23.web.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DispatcherController {

    @Autowired
    private DataService dataService;

//    @RequestMapping("/index")
//    public String toIndex() {
//        return "index";
//    }

    @RequestMapping("/index")
    public String  toIndex(HttpServletRequest request) {
        List<String> missionNames = dataService.getAllMissionNames();
        request.getSession().setAttribute("missionNames", missionNames);
        return "index";
    }

    @RequestMapping("/contact")
    public String toContact() {
        return "contact";
    }
}
