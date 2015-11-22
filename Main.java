package main;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {//still have to turn words in the end to real words instead of alphabatized ones
		long start = System.currentTimeMillis();
		Reader reader = new Reader();
		ArrayList<String> dictionaryLines = reader.read(args[0]);
		ArrayList<String> puzzleLines = reader.read(args[1]);
		TrieTree dictionary = new TrieTree();
		dictionary.insertList(dictionaryLines, 7);
		
		Pyramid pyramid = new Pyramid();
		pyramid.insertArrayListString(puzzleLines, 0, 8);
		solvePyramid(pyramid,dictionary);
		
//		reader.write(args[2], solutions);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");
	}
	
	public static StringBuilder solvePyramid(Pyramid pyramid, TrieTree dictionary){
		StringBuilder row = new StringBuilder();
		
		int[] empty = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		while(!Arrays.equals(pyramid.getBottom(), empty)){
			int[] bottom = pyramid.getBottom();
			int[] longest = dictionary.findDeepest(bottom);
			pyramid.removeLocations(longest);
			
			for(int j = 0; j < longest.length; j++){
				longest[j]++;
				row.append(longest[j]);
			}
			row.append(",");
		}
		return row;
	}
	
	
}
