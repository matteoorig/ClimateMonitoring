import javabeans.ClimateParameter;
import javabeans.MonitoringCoordinate;
import javabeans.Operator;
import parameters.*;
import persistence.ClimateParameterFileHandler;
import persistence.ElementNotFoundException;
import persistence.MonitoringCoordinateFileHandler;
import persistence.OperatorsFileHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ClimateMonitor {

    public static void main(String[] args) {

        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=new Date(ts.getTime());
        System.out.println(date);

        ClimateParameterFileHandler f = ClimateParameterFileHandler.getInstance();
        ClimateParameter mon = new ClimateParameter(2, "mori", 1, 82346286,
                new Wind(1, (byte) 1, "aaa"),
                new Humidity(2,  (byte) 2, "bbb"),
                new Pression(3,  (byte) 3, "ccc"),
                new Temperature(4,  (byte) 4, "ddd"),
                new RainFall(5,  (byte) 5, "eee"),
                new GlaciersAltitude(1,  (byte) 5, "fff"),
                new GlaciersMass(2,  (byte) 2, "alk"));

        try {
            f.writeClimateParameterInFile(mon);

        } catch (IOException e) {
            throw new RuntimeException("cannot locate file!");
        } /*catch (ElementNotFoundException e) {
            throw new RuntimeException("cannot locate file!");
        }*/

    }

}
