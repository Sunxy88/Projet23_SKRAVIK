package fr.imtatlantique.projet23.dao.stimulate.impl;

import fr.imtatlantique.projet23.web.dao.DataDao;
import fr.imtatlantique.projet23.entity.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/springmvc-context.xml", "classpath*:/spring/spring-context.xml"})
public class DataDaoImplTest{

    @Autowired
    private DataDao dataDao;

    @Test
    public void getAllDataTest() {
        List<Data> allData = dataDao.getAllData();
        System.out.println(allData);
    }

    @Test
    public void pureTest() {
    }
}
