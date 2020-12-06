package fr.imtatlantique.projet23.web.dao;

import fr.imtatlantique.projet23.entity.Data;

import java.util.List;

/**
 * @author Xi Song
 */
public interface DataDao {

    Data getData();
    List<Data> getAllData();

}
