package fr.imtatlantique.projet23.web.controller;

import fr.imtatlantique.projet23.web.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DispatcherController {

    @Autowired
    private DataService dataService;

    /**
     * When there is a request index.htm,
     * this method will send back the main page(src/main/webapp/WEB-INF/pages/index.jsp).
     * @param request
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String  toIndex(HttpServletRequest request) {
        List<String> missionNames = dataService.getAllMissionNames();
//        Add all missions' names to the page.
        request.getSession().setAttribute("missionNames", missionNames);
        return "index";
    }

    @RequestMapping("/contact")
    public String toContact() {
        return "contact";
    }
}

