package persistence;

import javabeans.ClimateParameter;
import javabeans.MonitoringCoordinate;
import parameters.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClimateParameterFileHandler extends FileHandler{
    private static final String FILENAME = "ParametriClimatici.csv";
    private static final int ID_COLUMN = 0;
    private static final int OPERATOR_COLUMN = 1;
    private static final int AREA_COLUMN = 2;
    private static final int DATE_COLUMN = 3;
    private static final int WIND_COLUMN = 4;
    private static final int WIND_SCORE_COLUMN = 5;
    private static final int WIND_DESCRIPTION_COLUMN = 6;
    private static final int HUMIDITY_COLUMN = 7;
    private static final int HUMIDITY_SCORE_COLUMN = 8;
    private static final int HUMIDITY_DESCRIPTION_COLUMN = 9;
    private static final int PRESSION_COLUMN = 10;
    private static final int PRESSION_SCORE_COLUMN = 11;
    private static final int PRESSION_DESCRIPTION_COLUMN = 12;
    private static final int TEMPERATURE_COLUMN = 13;
    private static final int TEMPERATURE_SCORE_COLUMN = 14;
    private static final int TEMPERATURE_DESCRIPTION_COLUMN = 15;
    private static final int RAINFALL_COLUMN = 16;
    private static final int RAINFALL_SCORE_COLUMN = 17;
    private static final int RAINFALL_DESCRIPTION_COLUMN = 18;
    private static final int GLACIERS_ALTITUDE_COLUMN = 19;
    private static final int GLACIERS_ALTITUDE_SCORE_COLUMN = 20;
    private static final int GLACIERS_ALTITUDE_DESCRIPTION_COLUMN = 21;
    private static final int GLACIERS_MASS_COLUMN = 22;
    private static final int GLACIERS_MASS_SCORE_COLUMN = 23;
    private static final int GLACIERS_MASS_DESCRIPTION_COLUMN = 24;

    private static ClimateParameterFileHandler instance = null;

    private ClimateParameterFileHandler() {
        super(FILENAME);
    }

    public static ClimateParameterFileHandler getInstance(){
        if(instance == null)
            return new ClimateParameterFileHandler();
        else
            return instance;
    }

    public ClimateParameter selectById(long id) throws IOException, ElementNotFoundException{
        super.openReading();
        String line;
        String[] columns;

        try {
            super.readLineFromFile(); // ignore first line
            line = super.readLineFromFile();

            while(line != null) {
                columns = super.parseCsvLine(line);

                if (Long.parseLong(columns[ID_COLUMN]) == id) {
                    return new ClimateParameter(Long.parseLong(columns[ID_COLUMN]),
                     columns[OPERATOR_COLUMN], Long.parseLong(columns[AREA_COLUMN]), Long.parseLong(columns[DATE_COLUMN]),
                            new Wind(Integer.parseInt(columns[WIND_COLUMN]), Byte.parseByte(columns[WIND_SCORE_COLUMN]), columns[WIND_DESCRIPTION_COLUMN]),
                            new Humidity(Integer.parseInt(columns[HUMIDITY_COLUMN]), Byte.parseByte(columns[HUMIDITY_SCORE_COLUMN]), columns[HUMIDITY_DESCRIPTION_COLUMN]),
                            new Pression(Integer.parseInt(columns[PRESSION_COLUMN]), Byte.parseByte(columns[PRESSION_SCORE_COLUMN]), columns[PRESSION_DESCRIPTION_COLUMN]),
                            new Temperature(Integer.parseInt(columns[TEMPERATURE_COLUMN]), Byte.parseByte(columns[TEMPERATURE_SCORE_COLUMN]), columns[TEMPERATURE_DESCRIPTION_COLUMN]),
                            new RainFall(Integer.parseInt(columns[RAINFALL_COLUMN]), Byte.parseByte(columns[RAINFALL_SCORE_COLUMN]), columns[RAINFALL_DESCRIPTION_COLUMN]),
                            new GlaciersAltitude(Integer.parseInt(columns[GLACIERS_ALTITUDE_COLUMN]), Byte.parseByte(columns[GLACIERS_ALTITUDE_SCORE_COLUMN]), columns[GLACIERS_ALTITUDE_DESCRIPTION_COLUMN]),
                            new GlaciersMass(Integer.parseInt(columns[GLACIERS_MASS_COLUMN]), Byte.parseByte(columns[GLACIERS_MASS_SCORE_COLUMN]), columns[GLACIERS_MASS_DESCRIPTION_COLUMN])
                            );
                }

                line = super.readLineFromFile();

            }

            super.closeReading();

            throw new ElementNotFoundException("operator not found! searched id: " + id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<ClimateParameter> selectByOperator(String nick) throws IOException, ElementNotFoundException{
        super.openReading();
        String line;
        String[] columns;
        List<ClimateParameter> list = new ArrayList<>();


        try {
            super.readLineFromFile(); // ignore first line
            line = super.readLineFromFile();

            while(line != null) {
                columns = super.parseCsvLine(line);

                if (columns[OPERATOR_COLUMN].compareTo(nick) == 0) {
                    list.add(new ClimateParameter(Long.parseLong(columns[ID_COLUMN]),
                            columns[OPERATOR_COLUMN], Long.parseLong(columns[AREA_COLUMN]), Long.parseLong(columns[DATE_COLUMN]),
                            new Wind(Integer.parseInt(columns[WIND_COLUMN]), Byte.parseByte(columns[WIND_SCORE_COLUMN]), columns[WIND_DESCRIPTION_COLUMN]),
                            new Humidity(Integer.parseInt(columns[HUMIDITY_COLUMN]), Byte.parseByte(columns[HUMIDITY_SCORE_COLUMN]), columns[HUMIDITY_DESCRIPTION_COLUMN]),
                            new Pression(Integer.parseInt(columns[PRESSION_COLUMN]), Byte.parseByte(columns[PRESSION_SCORE_COLUMN]), columns[PRESSION_DESCRIPTION_COLUMN]),
                            new Temperature(Integer.parseInt(columns[TEMPERATURE_COLUMN]), Byte.parseByte(columns[TEMPERATURE_SCORE_COLUMN]), columns[TEMPERATURE_DESCRIPTION_COLUMN]),
                            new RainFall(Integer.parseInt(columns[RAINFALL_COLUMN]), Byte.parseByte(columns[RAINFALL_SCORE_COLUMN]), columns[RAINFALL_DESCRIPTION_COLUMN]),
                            new GlaciersAltitude(Integer.parseInt(columns[GLACIERS_ALTITUDE_COLUMN]), Byte.parseByte(columns[GLACIERS_ALTITUDE_SCORE_COLUMN]), columns[GLACIERS_ALTITUDE_DESCRIPTION_COLUMN]),
                            new GlaciersMass(Integer.parseInt(columns[GLACIERS_MASS_COLUMN]), Byte.parseByte(columns[GLACIERS_MASS_SCORE_COLUMN]), columns[GLACIERS_MASS_DESCRIPTION_COLUMN])
                    ));
                }

                line = super.readLineFromFile();

            }

            super.closeReading();

            if(list.isEmpty())
                throw new ElementNotFoundException("operator not found! searched nick: " + nick);
            else
                return list;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClimateParameter> selectByArea(long areaId) throws IOException, ElementNotFoundException{
        super.openReading();
        String line;
        String[] columns;
        List<ClimateParameter> list = new ArrayList<>();


        try {
            super.readLineFromFile(); // ignore first line
            line = super.readLineFromFile();

            while(line != null) {
                columns = super.parseCsvLine(line);

                if (Long.parseLong(columns[AREA_COLUMN]) == areaId) {
                    list.add(new ClimateParameter(Long.parseLong(columns[ID_COLUMN]),
                            columns[OPERATOR_COLUMN], Long.parseLong(columns[AREA_COLUMN]), Long.parseLong(columns[DATE_COLUMN]),
                            new Wind(Integer.parseInt(columns[WIND_COLUMN]), Byte.parseByte(columns[WIND_SCORE_COLUMN]), columns[WIND_DESCRIPTION_COLUMN]),
                            new Humidity(Integer.parseInt(columns[HUMIDITY_COLUMN]), Byte.parseByte(columns[HUMIDITY_SCORE_COLUMN]), columns[HUMIDITY_DESCRIPTION_COLUMN]),
                            new Pression(Integer.parseInt(columns[PRESSION_COLUMN]), Byte.parseByte(columns[PRESSION_SCORE_COLUMN]), columns[PRESSION_DESCRIPTION_COLUMN]),
                            new Temperature(Integer.parseInt(columns[TEMPERATURE_COLUMN]), Byte.parseByte(columns[TEMPERATURE_SCORE_COLUMN]), columns[TEMPERATURE_DESCRIPTION_COLUMN]),
                            new RainFall(Integer.parseInt(columns[RAINFALL_COLUMN]), Byte.parseByte(columns[RAINFALL_SCORE_COLUMN]), columns[RAINFALL_DESCRIPTION_COLUMN]),
                            new GlaciersAltitude(Integer.parseInt(columns[GLACIERS_ALTITUDE_COLUMN]), Byte.parseByte(columns[GLACIERS_ALTITUDE_SCORE_COLUMN]), columns[GLACIERS_ALTITUDE_DESCRIPTION_COLUMN]),
                            new GlaciersMass(Integer.parseInt(columns[GLACIERS_MASS_COLUMN]), Byte.parseByte(columns[GLACIERS_MASS_SCORE_COLUMN]), columns[GLACIERS_MASS_DESCRIPTION_COLUMN])
                    ));
                }

                line = super.readLineFromFile();

            }

            super.closeReading();

            if(list.isEmpty())
                throw new ElementNotFoundException("operator not found! searched area: " + areaId);
            else
                return list;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeClimateParameterInFile(ClimateParameter param) throws IOException {
        super.openWriting();

        super.writeLineInFile(param.getId() + CSV_DELIMETER +
                param.getOperatorNickname()  + CSV_DELIMETER + param.getAreaOfInterest() + CSV_DELIMETER + param.getDate()  + CSV_DELIMETER +
                param.getWind().getValue()  + CSV_DELIMETER + param.getWind().getScore() + CSV_DELIMETER + param.getWind().getDescription() + CSV_DELIMETER +
                param.getHumidity().getValue() + CSV_DELIMETER + param.getHumidity().getScore() + CSV_DELIMETER + param.getHumidity().getDescription() + CSV_DELIMETER +
                param.getPression().getValue() + CSV_DELIMETER + param.getPression().getScore() + CSV_DELIMETER + param.getPression().getDescription() + CSV_DELIMETER +
                param.getTemperature().getValue() + CSV_DELIMETER + param.getTemperature().getScore() + CSV_DELIMETER + param.getTemperature().getDescription() + CSV_DELIMETER +
                param.getRainfall().getValue() + CSV_DELIMETER + param.getRainfall().getScore() + CSV_DELIMETER + param.getRainfall().getDescription() + CSV_DELIMETER +
                param.getGlaciersAltitude().getValue() + CSV_DELIMETER + param.getGlaciersAltitude().getScore() + CSV_DELIMETER + param.getGlaciersAltitude().getDescription() + CSV_DELIMETER +
                param.getGlaciersMass().getValue() + CSV_DELIMETER + param.getGlaciersMass().getScore() + CSV_DELIMETER + param.getGlaciersMass().getDescription());

        super.closeWriting();
    }
}
