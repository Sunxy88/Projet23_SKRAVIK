package fr.imtatlantique.projet23.web.service.impl;

import fr.imtatlantique.projet23.web.dao.DataDao;
import fr.imtatlantique.projet23.entity.Data;
import fr.imtatlantique.projet23.web.service.MapService;
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
