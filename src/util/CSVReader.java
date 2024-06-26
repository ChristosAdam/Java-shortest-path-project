package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVReader {
	 
	/* Attributes / Data
	 ----------------------------------------------------------------------------------------------*/
	private String path;
	private String fileName;
	private String header;

	/* Constructor
	 ----------------------------------------------------------------------------------------------*/	
	public CSVReader(String folderName) {

		path = new File("").getAbsolutePath() + "/" + folderName + "/";

	}
	

	/* Load methods (main methods of the class) to read each line of the CSV file
	 ----------------------------------------------------------------------------------------------*/		
	public ArrayList<String> load(String fileName) {
		this.fileName = fileName;
		
        ArrayList<String> allRecords = new ArrayList<String>();
        
        // pathBase = "/Users/fernando/Desktop/computation3_workspace/Example_13_LoadSaveMovies/src/db/"; // absolute path

        
        try {
        	FileReader file = new FileReader(path + fileName);
        	        	
            BufferedReader inputBuffer = new BufferedReader( file );
            
            String line = inputBuffer.readLine();
            
            while (line != null) {
            	//System.out.println(line);
            	
            	allRecords.add(line);
                line = inputBuffer.readLine();
            }
            
            inputBuffer.close();
            
            header = allRecords.get(0);

            allRecords.remove(0); // Excludes first line in case there is a header.
        } catch (Exception e) {
            System.out.println(e);
        }
                
        return allRecords;
	}
	
	/* Getters
	 ----------------------------------------------------------------------------------------------*/	
	public String getHeader() {
		return header;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getFullPathFileName() {
		return path + fileName;
	}
}
