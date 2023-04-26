package persistence;

import java.io.*;

public abstract class FileHandler {

    private final static String FILE_PATH = "data" + File.separator;
    private final static String CSV_DELIMETER = ";";
    protected final static String ARRAY_DELIMETER = ",";

    protected String fileName;
    protected BufferedReader bufferedReader;

    protected FileHandler(){

   }

    protected FileHandler(String filename){
       this.fileName = filename;

   }



    protected final void openFile() throws FileNotFoundException{
        System.out.println("  try to open: " + FILE_PATH + this.fileName);
        FileReader f = new FileReader(FILE_PATH + this.fileName);
           this.bufferedReader = new BufferedReader(f);
           //System.out.println("  operatorsReader: " + operatorsReader);
   }
    protected final String readLineFromFile() throws IOException{
            return this.bufferedReader.readLine();
    }

    protected final String[] parseCsvLine(String line){
        return line.split(CSV_DELIMETER);
    }

    protected final void closeFile() throws IOException{
            this.bufferedReader.close();
    }

}
