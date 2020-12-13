package fr.imtatlantique.projet23.web.controller;

import fr.imtatlantique.projet23.entity.Data;
import fr.imtatlantique.projet23.web.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping("/doGetMission")
    public ModelAndView doGetMission(Integer missionId, Boolean airTemp, Boolean salinity) {
        String missionName = "mission" + missionId;
        ModelAndView response = new ModelAndView();
        List<Data> datas = null;
        response.setViewName("index");

        try {
            datas = dataService.getDataByMissionName(missionName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        fillCordinate(response, datas, airTemp == null ? false : true, salinity == null ? false : true);

        return response;
    }

    private void fillCordinate(ModelAndView response, List<Data> datas, boolean airTemp, boolean isSalinity) {
        if (datas != null) {
            List<Double> latitudes = new ArrayList<>();
            List<Double> longitudes = new ArrayList<>();
            List<String> dates = new ArrayList<>();
            List<Double> airTemperatures = new ArrayList<>();
            List<Double> salinity = new ArrayList<>();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Data data : datas) {
                Double longitude, latitude;
                if ((latitude = data.getLatitude()) == null || (longitude = data.getLongitude()) == null) {
                    continue;
                }
                longitudes.add(longitude);
                latitudes.add(latitude);
                dates.add("'" + df.format(data.getDate()) + "'");
                if (airTemp) {
                    airTemperatures.add(data.getAirtemperature());
                }
                if (isSalinity) {
                    salinity.add(data.getSalinity());
                }
            }
            System.out.println(datas.get(0).getDate());
            Map map = new HashMap();
            map.put("longitudes", longitudes);
            map.put("latitudes", latitudes);
            map.put("dates", dates);
            if (airTemp) {
                map.put("aitTemperatures", airTemperatures);
            }
            if (isSalinity) {
                map.put("salinity", salinity);
            }
            response.addAllObjects(map);
        }
    }
}
