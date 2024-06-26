package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {
	
	/* Attributes / Data
	 ----------------------------------------------------------------------------------------------*/
	private String path;
	private String header;
	private String fileName;
	private FileWriter fileWriter;

	/* Constructor
	 ----------------------------------------------------------------------------------------------*/
	public CSVWriter(String path, String fileName, String header) {
		this.path = path;
		this.fileName = fileName;
		this.header = header;
	}
	
	/* Save the records
	 ----------------------------------------------------------------------------------------------*/

	public void save(ArrayList<String> allRecords){

		if (allRecords != null) {

			try {
				// File (set of runs) variables
				fileWriter = new FileWriter(path + fileName);

				fileWriter.append(header); 				// Add CSV file header (columns name)
				fileWriter.append(CSVHelper.NEW_LINE_SEPARATOR);	// Add the line separator

				for (int i = 0; i < allRecords.size(); i++){
					fileWriter.append(allRecords.get(i)); 	// append the record
					fileWriter.append(CSVHelper.NEW_LINE_SEPARATOR);	// append new line separator to store the next record (line)
				}

			} catch (Exception e) {
				System.out.println("Error in CsvFileWriter !!!");
				e.printStackTrace();
			} finally {
				try {	
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					System.out.println("Error while flushing/closing fileWriter !!!");
					e.printStackTrace();
				}        
			}
		}
	}
	
	/* Getters
	 ----------------------------------------------------------------------------------------------*/
	public String getPath() {
		return path;
	}

	public String getFileName() {
		return fileName;
	}
	
	public String getHeader() {
		return header;
	}
}
