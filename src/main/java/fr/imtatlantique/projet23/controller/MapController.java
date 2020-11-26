package fr.imtatlantique.projet23.controller;

import fr.imtatlantique.projet23.common.Result;
import fr.imtatlantique.projet23.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data")
public class MapController {

    @Autowired
    private MapService mapService;

    @ResponseBody
    @RequestMapping("/doGetAll")
    public Object doGetAll() {
        Result result = new Result();
        try {
            result.setData(mapService.getAllData());
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
