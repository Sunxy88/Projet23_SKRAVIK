package fr.imtatlantique.projet23.web.service;

import fr.imtatlantique.projet23.entity.Data;

import java.util.List;

public interface DataService {
    List<Data> getDataByMissionName(String missionName);

    List<String> getAllMissionNames();
}
