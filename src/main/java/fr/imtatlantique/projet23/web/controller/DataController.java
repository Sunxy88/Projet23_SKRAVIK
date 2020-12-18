package fr.imtatlantique.projet23.web.controller;

import fr.imtatlantique.projet23.entity.Data;
import fr.imtatlantique.projet23.web.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Xi Song
 */
@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    /**
     * When receive a 'doGetMission' request with missionName (the mission want to check),
     * this method will call dataService to get data from database (getDataByMissionName()).
     * Data will be combined in desired way (it is up to if the salinity box or air temperature box is checked).
     * @param missionName the mission that user want to check
     * @param airTemp indicates if air temperature checkbox is checked
     * @param velocity indicates if velocity checkbox is checked
     * @return
     */
    @RequestMapping(value = "/doGetMission", method = RequestMethod.POST)
    public ModelAndView doGetMission(String missionName, Boolean airTemp, Boolean velocity, Boolean pression) {
        ModelAndView response = new ModelAndView();
        List<Data> datas = null;
        response.setViewName("index");

        try {
            datas = dataService.getDataByMissionName(missionName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        fillCoordinate(response, datas, airTemp != null, velocity != null, pression != null);

        return response;
    }

    /**
     * Combine data and put data in the response.
     * @param response
     * @param datas
     * @param airTemp
     * @param isVelocity
     */
    private void fillCoordinate(ModelAndView response, List<Data> datas, boolean airTemp, boolean isVelocity, boolean isPression) {
        if (datas != null) {
            List<Double> latitudes = new ArrayList<>();
            List<Double> longitudes = new ArrayList<>();
            List<String> dates = new ArrayList<>();
            List<Double> airTemperatures = new ArrayList<>();
            List<Double> velocity = new ArrayList<>();
            List<Double> pressure = new ArrayList<>();
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
                if (isVelocity) {
                    velocity.add(data.getVelocity());
                }
                if (isPression) {
                    pressure.add(data.getAtmpressure());
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
            if (isVelocity) {
                map.put("velocity", velocity);
            }
            if (isPression) {
                map.put("pressure", pressure);
            }
            response.addAllObjects(map);
        }
    }
}
