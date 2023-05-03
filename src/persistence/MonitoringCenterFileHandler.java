package persistence;

import javabeans.MonitoringCenter;
import javabeans.MonitoringCoordinate;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MonitoringCenterFileHandler extends FileHandler{

    private static final String FILENAME = "CentriMonitoraggio.csv";

    private static final int NAME_COLUMN = 0;
    private static final int ADDRESS_COLUMN = 1;
    private static final int AREA_LIST_COLUMN = 2;

    private static MonitoringCenterFileHandler instance = null;

    private MonitoringCenterFileHandler() {
        super(FILENAME);
    }

    public static MonitoringCenterFileHandler getInstance(){
        if(instance == null)
            return new MonitoringCenterFileHandler();
        else
            return instance;
    }

    public MonitoringCenter selectByName(String name) throws IOException, ElementNotFoundException{

        super.openReading();
        String line;
        String[] columns;

        try {
            super.readLineFromFile(); // ignore first line
            line = super.readLineFromFile();

            while(line != null) {
                columns = super.parseCsvLine(line);

                if (columns[NAME_COLUMN].compareTo(name) == 0) {
                    return new MonitoringCenter(columns[NAME_COLUMN], columns[ADDRESS_COLUMN],
                           parseAreaList(columns[AREA_LIST_COLUMN]));
                }

                line = super.readLineFromFile();

            }

            super.closeReading();

            throw new ElementNotFoundException("operator not found! searched name: " + name);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private long[] parseAreaList(String line){

        if(line.compareTo("") == 0 || line == null)
            return null;

        String[] array = line.split(ARRAY_DELIMETER);
        long[] list = new long[array.length];

        for (int i = 0; i < array.length; i++)
            list[i] = Long.parseLong(array[i]);

        return list;
    }

    public void writeMonitoringCenterInFile(MonitoringCenter cen) throws IOException {
        super.openWriting();

        super.writeLineInFile(cen.getName() + CSV_DELIMETER + cen.getAddress() + CSV_DELIMETER +
                cen.getAreaList());

        super.closeWriting();
    }
}
