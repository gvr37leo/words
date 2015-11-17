package main;
import java.io.*;
import java.util.ArrayList;

public class Reader {
	public ArrayList<String> read(String file){
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		try {
			FileReader 	fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null) {
	            lines.add(line);
	        }   
	        bufferedReader.close();  
		} catch(FileNotFoundException ex) {
			System.out.println(file + " is not present in this directory");
		}
	    catch(IOException ex) {
	    	System.out.println("wrong input");
	    }
		return lines;
	}
	
	public void write(String file,ArrayList<String> lines){
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			for (String line : lines) {
				bufferWriter.write(line);
				bufferWriter.newLine();
			}
			bufferWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
