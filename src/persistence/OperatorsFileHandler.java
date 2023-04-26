package persistence;

import javabeans.Operator;

import java.io.FileNotFoundException;
import java.io.IOException;

public final class OperatorsFileHandler extends FileHandler{

    private static final String FILENAME = "OperatoriRegistrati.csv";

    private static final int NICKNAME_COLUMN = 0;
    private static final int PASSWORD_COLUMN = 1;
    private static final int MONITORING_CENTER_ID_COLUMN = 2;

    private static OperatorsFileHandler instance = null;

    private OperatorsFileHandler() {
        super(FILENAME);
    }

    public static OperatorsFileHandler getInstance(){
        if(instance == null)
            return new OperatorsFileHandler();
        else
            return instance;
    }

    public Operator selectByNickname(String nickname) throws FileNotFoundException, ElementNotFoundException{
        super.openFile();
        String line;
        String[] columns;

        try {
            super.readLineFromFile(); // ignore first line
            line = super.readLineFromFile();

            while(line != null) {
                columns = super.parseCsvLine(line);

                if (columns[NICKNAME_COLUMN].compareTo(nickname) == 0) {
                    return new Operator(columns[NICKNAME_COLUMN], columns[PASSWORD_COLUMN],
                            columns[MONITORING_CENTER_ID_COLUMN]);
                }

                line = super.readLineFromFile();

            }

            super.closeFile();

            throw new ElementNotFoundException("operator not found! searched nickname: " + nickname);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
