package persistence;

import javabeans.MonitoringCenter;
import javabeans.MonitoringCoordinate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonitoringCoordinateFileHandler extends FileHandler{
    private static final String FILENAME = "CoordinateMonitoraggio.csv";
    private static final int GEONAME_COLUMN = 0;
    private static final int LATITUDE_COLUMN = 1;
    private static final int LONGITUDE_COLUMN = 2;
    private static final int DENOMINATION_COLUMN = 3;
    private static final int COUNTRY_CODE_COLUMN = 4;

    private static MonitoringCoordinateFileHandler instance = null;

    private MonitoringCoordinateFileHandler() {
        super(FILENAME);
    }

    public static MonitoringCoordinateFileHandler getInstance(){
        if(instance == null)
            return new MonitoringCoordinateFileHandler();
        else
            return instance;
    }

    public MonitoringCoordinate selectByGeoname(long geoname) throws FileNotFoundException, ElementNotFoundException{

        super.openFile();
        String line;
        String[] columns;

        try {
            super.readLineFromFile(); // ignore first line
            line = super.readLineFromFile();

            while(line != null) {
                columns = super.parseCsvLine(line);

                if (Long.parseLong(columns[GEONAME_COLUMN]) == geoname) {
                    return new MonitoringCoordinate(Long.parseLong(columns[GEONAME_COLUMN]),
                            Double.parseDouble(columns[LATITUDE_COLUMN]), Double.parseDouble(columns[LONGITUDE_COLUMN]),
                            columns[DENOMINATION_COLUMN], columns[COUNTRY_CODE_COLUMN]);
                }

                line = super.readLineFromFile();

            }

            super.closeFile();

            throw new ElementNotFoundException("operator not found! searched geoname: " + geoname);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<MonitoringCoordinate> selectByCountryCode(String countryCode) throws FileNotFoundException, ElementNotFoundException{

        List<MonitoringCoordinate> list = new ArrayList<>();
        super.openFile();
        String line;
        String[] columns;

        try {
            super.readLineFromFile(); // ignore first line
            line = super.readLineFromFile();

            while(line != null) {
                columns = super.parseCsvLine(line);

                if (columns[COUNTRY_CODE_COLUMN].compareTo(countryCode) == 0) {
                    list.add(new MonitoringCoordinate(Long.parseLong(columns[GEONAME_COLUMN]),
                            Double.parseDouble(columns[LATITUDE_COLUMN]), Double.parseDouble(columns[LONGITUDE_COLUMN]),
                            columns[DENOMINATION_COLUMN], columns[COUNTRY_CODE_COLUMN]));
                }

                line = super.readLineFromFile();

            }
            super.closeFile();

            if(list.isEmpty())
                throw new ElementNotFoundException("operator not found! searched country code: " + countryCode);

            return list;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
