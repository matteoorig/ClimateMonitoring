package persistence;

import javabeans.Operator;

import java.io.IOException;

public final class OperatorsFileHandler extends FileHandler{

    private static final String FILENAME = "OperatoriRegistrati.csv";

    private static final int NICKNAME_COLUMN = 0;
    private static final int NAME_COLUMN = 1;
    private static final int SURNAME_COLUMN = 2;
    private static final int MAIL_COLUMN = 3;
    private static final int FISCAL_CODE_COLUMN = 4;
    private static final int PASSWORD_COLUMN = 5;
    private static final int MONITORING_CENTER_ID_COLUMN = 6;

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

    public Operator selectByNickname(String nickname) throws ElementNotFoundException, IOException{
        super.openReading();
        String line;
        String[] columns;

        try {
            super.readLineFromFile(); // ignore first line
            line = super.readLineFromFile();

            while(line != null) {
                columns = super.parseCsvLine(line);

                if (columns[NICKNAME_COLUMN].compareTo(nickname) == 0) {
                    return new Operator(columns[NICKNAME_COLUMN], columns[NAME_COLUMN], columns[SURNAME_COLUMN],
                            columns[MAIL_COLUMN], columns[FISCAL_CODE_COLUMN], columns[PASSWORD_COLUMN],
                            columns[MONITORING_CENTER_ID_COLUMN]);
                }

                line = super.readLineFromFile();

            }

            super.closeReading();

            throw new ElementNotFoundException("operator not found! searched nickname: " + nickname);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeOperatorInFile(Operator op) throws IOException {
        super.openWriting();
        super.writeLineInFile( op.getNickname() + CSV_DELIMETER + op.getName() + CSV_DELIMETER +
                op.getSurname() + CSV_DELIMETER + op.getMail() + CSV_DELIMETER +
                op.getFiscalCode() + CSV_DELIMETER + op.getPassword() + CSV_DELIMETER +
                op.getMonitoringCenter());

        super.closeWriting();
    }
}
