package fr.imtatlantique.projet23.web.service.impl;

import fr.imtatlantique.projet23.web.dao.DataMapper;
import fr.imtatlantique.projet23.entity.Data;
import fr.imtatlantique.projet23.web.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<Data> getDataByMissionName(String missionName) {
        Map map = new HashMap(1);
        map.put("missionName", missionName);
        return dataMapper.getDataByMissionName(map);
    }
}
