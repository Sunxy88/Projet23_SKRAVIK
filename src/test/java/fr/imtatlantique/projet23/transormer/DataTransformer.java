package fr.imtatlantique.projet23.transormer;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class DataTransformer {

    private String data_mission_name = "/simulate_original_data/data_mission_";
    private String extand = ".txt";
    private String[] data_mission_path;
    private String insertStatement = "INSERT INTO data_table (date, loch, latitude, longitude, surfHeading, trueHeading, velocity, depth, aws, tws, awd, twd, airTemperature, atmPressure, humidity, sunPower, waterTemperature, salinity, o2, missionName) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);";
    private File[] inputFiles;
    private static final int NUMBER_OF_MISSION = 5;

    @Before
    public void setUp() {
        data_mission_path = new String[NUMBER_OF_MISSION];
        inputFiles = new File[NUMBER_OF_MISSION];
        for (int i = 1; i <= NUMBER_OF_MISSION; i++) {
            data_mission_path[i - 1] = data_mission_name + "0" + i + extand;
            inputFiles[i - 1] = new File(getClass().getResource(data_mission_path[i - 1]).getFile());
        }
    }

    @Test
    public void transferTest() throws IOException {
        File insertStatementTxt = new File(getClass().getResource("/simulate_sql_data/insertStatement.txt").getFile());
        if (!insertStatementTxt.exists()) {
            insertStatementTxt.createNewFile();
        }
        System.out.println(insertStatementTxt);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(insertStatementTxt)));
        writer.write("");
        writer.flush();
        for (int i = 0; i < NUMBER_OF_MISSION; i++) {
            File mission = inputFiles[i];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(mission)));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                String[] split = line.split(" ");
                String dateStr = split[0];
                dateStr = dateStr.replace('T', ' ');
                String insert = String.format(insertStatement, "'" + dateStr + "'", split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], split[9], split[10],split[11], split[13], split[14], split[15], split[16], split[17], split[18], split[19], "'mission" + (i + 1) +"'");
                writer.write(insert + "\n");
            }

            bufferedReader.close();
        }
    }
}
