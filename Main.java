package main;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	//optimazations 
	//1 why does it run faster in eclipse
	//2 the -1 thing
	public static void main(String[] args) {//still have to turn words in the end to real words instead of alphabatized ones
		long start = System.currentTimeMillis();
		Reader reader = new Reader();
		ArrayList<String> dictionaryLines = reader.read(args[0]);
		ArrayList<String> puzzleLines = reader.read(args[1]);
		
		
		
//		reader.write(args[2], solutions);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");
	}
}
