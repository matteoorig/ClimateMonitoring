import javabeans.ClimateParameter;
import javabeans.MonitoringCoordinate;
import javabeans.Operator;
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
import java.util.Date;

class ClimateMonitor {

    public static void main(String[] args) {

        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=new Date(ts.getTime());
        System.out.println(date);

        ClimateParameterFileHandler f = ClimateParameterFileHandler.getInstance();
        ClimateParameter mon;

        try {
            mon = f.selectById(1);
            System.out.println(mon.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException("cannot locate file!");
        } catch (ElementNotFoundException e) {
            throw new RuntimeException("element not found!");
        }

    }

}
