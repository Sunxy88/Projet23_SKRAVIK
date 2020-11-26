package fr.imtatlantique.projet23.dao.stimulate.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import fr.imtatlantique.projet23.dao.stimulate.DataDao;
import fr.imtatlantique.projet23.entity.Data;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Get all data from the stimulate dataset
 * @author song xi
 */
@Component
public class DataDaoImpl implements DataDao {

    private String dataPath = this.getClass().getClassLoader().getResource("stimulateData/dataset.csv").getPath();
    private File csv = new File(dataPath);

    /**
     * TODO: According to what to get one specific data ?
     * @return
     */
    @Override
    public Data getData() {
        return null;
    }

    /**
     * Get all data from dataset
     * @return a list of all data
     */
    @Override
    public List<Data> getAllData() {

        List<Data> dataList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try (CSVReaderHeaderAware reader = new CSVReaderHeaderAwareBuilder(
                new BufferedReader(new InputStreamReader(new FileInputStream(csv)))).build()) {
            Iterator<String[]> iterator = reader.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                String[] curLine = iterator.next();
                curLine = curLine[0].split(";");
                Data data = new Data();

                try {
                    data.setDate(sdf.parse(curLine[0]));
                    data.setLatitude(curLine[1].length() != 0 ? Double.valueOf(curLine[1]) : null);
                    data.setLongitude(curLine[2].length() != 0 ? Double.valueOf(curLine[2]) : null);
                    data.setSurfSpeed(curLine[3].length() != 0 ? Double.valueOf(curLine[3]) : null);
                    data.setSpeedOverGnd(curLine[4].length() != 0 ? Double.valueOf(curLine[4]) : null);
                    data.setSurfHeading(curLine[5].length() != 0 ? Double.valueOf(curLine[5]) : null);
                    data.setHeadingOverGround(curLine[6].length() != 0 ? Double.valueOf(curLine[6]) : null);
                    data.setLoch(curLine[7].length() != 0 ? Double.valueOf(curLine[7]) : null);
                    data.setDepth(curLine[8].length() != 0 ? Double.valueOf(curLine[8]) : null);
                    data.setAws(curLine[9].length() != 0 ? Double.valueOf(curLine[9]) : null);
                    data.setTws(curLine[10].length() != 0 ? Double.valueOf(curLine[10]) : null);
                    data.setTwd(curLine[11].length() != 0 ? Double.valueOf(curLine[11]) : null);
                    data.setAirTempearture(curLine[12].length() != 0 ? Double.valueOf(curLine[12]) : null);
                    data.setPression(curLine[13].length() != 0 ? Double.valueOf(curLine[13]) : null);
                    data.setHumidity(curLine[14].length() != 0 ? Double.valueOf(curLine[14]) : null);
                    data.setSunPower(curLine[15].length() != 0 ? Double.valueOf(curLine[15]) : null);
                    data.setWaterTemperature(curLine[16].length() != 0 ? Double.valueOf(curLine[16]) : null);
                    data.setSalinity(curLine[17].length() != 0 ? Double.valueOf(curLine[17]) : null);
                    data.setO2Conc(curLine[18].length() != 0 ? Double.valueOf(curLine[18]) : null);
                    dataList.add(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                Arrays.stream(curLine).forEach(System.out::print);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
