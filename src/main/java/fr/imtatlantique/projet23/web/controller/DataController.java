package fr.imtatlantique.projet23.web.controller;

import fr.imtatlantique.projet23.entity.Data;
import fr.imtatlantique.projet23.web.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping("/doGetMission")
    public ModelAndView doGetMission(Integer missionId) {
        String missionName = "mission" + missionId;
        ModelAndView response = new ModelAndView();
        List<Data> datas = null;
        response.setViewName("index");

        try {
            datas = dataService.getDataByMissionName(missionName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        fillCordinate(response, datas);

        return response;
    }

    private void fillCordinate(ModelAndView response, List<Data> datas) {
        if (datas != null) {
            List<Double> latitudes = new ArrayList<>();
            List<Double> longitudes = new ArrayList<>();
            for (Data data : datas) {
                Double longitude, latitude;
                if ((latitude = data.getLatitude()) == null || (longitude = data.getLongitude()) == null) {
                    continue;
                }
                longitudes.add(Math.max(-longitude, longitude));
                latitudes.add(Math.max(-latitude, latitude));
            }
            Map map = new HashMap();
            map.put("longitudes", longitudes);
            map.put("latitudes", latitudes);
            response.addAllObjects(map);
        }
    }
}
