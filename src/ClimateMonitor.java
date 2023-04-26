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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ClimateMonitor {

    public static void main(String[] args) {

        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=new Date(ts.getTime());
        System.out.println(date);

        ClimateParameterFileHandler f = ClimateParameterFileHandler.getInstance();
        ClimateParameter mon;
        List<ClimateParameter> list = new ArrayList<>();

        try {
            list = f.selectByArea(1);
            System.out.println(list.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException("cannot locate file!");
        } catch (ElementNotFoundException e) {
            throw new RuntimeException("element not found!");
        }

    }

}
