package persistence;

import java.io.*;

public abstract class FileHandler {

    private final static String FILE_PATH = "data" + File.separator;
    protected final static String CSV_DELIMETER = ";";
    protected final static String ARRAY_DELIMETER = ",";

    private String fileName;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;


    protected FileHandler(){
   }

    protected FileHandler(String filename){
       this.fileName = filename;

   }

    protected final void openWriting() throws IOException{
        FileWriter w = new FileWriter(FILE_PATH + this.fileName, true);
        this.bufferedWriter = new BufferedWriter(w);

    }

    protected final void openReading() throws IOException{
        FileReader f = new FileReader(FILE_PATH + this.fileName);
        this.bufferedReader = new BufferedReader(f);
   }
    protected final String readLineFromFile() throws IOException{
        return this.bufferedReader.readLine();
    }

    protected final String[] parseCsvLine(String line){
        return line.split(CSV_DELIMETER);
    }

    protected final void closeReading() throws IOException{
        this.bufferedReader.close();
    }

    protected final void writeLineInFile(String s) throws IOException{
        this.bufferedWriter.newLine();
        this.bufferedWriter.append(s);
    }

    protected final void closeWriting() throws IOException{
        this.bufferedWriter.close();
    }
}
