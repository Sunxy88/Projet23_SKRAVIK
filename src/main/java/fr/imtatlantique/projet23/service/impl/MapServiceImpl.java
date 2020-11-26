package fr.imtatlantique.projet23.service.impl;

import fr.imtatlantique.projet23.dao.stimulate.DataDao;
import fr.imtatlantique.projet23.entity.Data;
import fr.imtatlantique.projet23.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private DataDao dataDao;

    @Override
    public List<Data> getAllData() {
        return dataDao.getAllData();
    }
}
