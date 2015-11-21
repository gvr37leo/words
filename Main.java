package main;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	//optimazations 
	//skip duplicates
	//2 the -1 thing
	//stringbuilder
	//do 1 write
	public static void main(String[] args) {//still have to turn words in the end to real words instead of alphabatized ones
		long start = System.currentTimeMillis();
		Reader reader = new Reader();
		ArrayList<String> dictionaryLines = reader.read(args[0]);
		ArrayList<String> puzzleLines = reader.read(args[1]);

//		TrieTree trieTree = new TrieTree();
//		trieTree.value = -1;// ugly thing has due to weirdish implementation of trietree
//		trieTree.insertList(dictionaryLines);
		
		TrieTree unalphabetized = new TrieTree();
		unalphabetized.insertList(dictionaryLines);
		
		StringBuilder row = new StringBuilder();
		for(int i = 0; i < puzzleLines.size() / 8; i++){
			
			Pyramid pyramid = new Pyramid();
			pyramid.insertArrayListString(puzzleLines, i * 8, i * 8 + 8);
		
			int[] empty = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
			while(!Arrays.equals(pyramid.getBottom(), empty)){
				int[] bottom = pyramid.getBottom();
				LinkedList longest = unalphabetized.findDeepestUnsorted(bottom);
				longest.remove(longest.getLength() - 1);// -1 due to bug
				pyramid.removeLocations(longest.arrayifi());// removearray doesnt work here
				
				int[] array = longest.arrayifi();
				
				for(int j = 0; j < array.length; j++){
					array[j]++;
					row.append(array[j]);
				}
				row.append(",");
			}
			row.append("\r\n");
		}
		ArrayList<String> test = new ArrayList<String>();
		test.add(row.toString());
		
		reader.write(args[2], test);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");
	}
}
