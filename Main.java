package main;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	//optimazations 
	//1 why does it run faster in eclipse
	//2 the -1 thing
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Reader reader = new Reader();
		ArrayList<String> dictionaryLines = reader.read(args[0]);
		ArrayList<String> puzzleLines = reader.read(args[1]);

		TrieTree trieTree = new TrieTree();
		trieTree.value = -1;// ugly thing has due to weirdish implementation of trietree
		trieTree.insertList(dictionaryLines);
		
		ArrayList<String> solutions = new ArrayList<String>();
		for(int i = 0; i < puzzleLines.size() / 8; i++){
			String string = "";
			Pyramid pyramid = new Pyramid();
			pyramid.insertArrayListString(puzzleLines, i * 8, i * 8 + 8);
			
			int[] empty = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
			while(!Arrays.equals(pyramid.getBottom(), empty)){
				int[] bottom = pyramid.getBottom();
				Arrays.sort(bottom);
				LinkedList biggestWord = trieTree.findDeepest(bottom);
				boolean[] removed = pyramid.removeArray(biggestWord.arrayifi());
				for(int j = 0; j < removed.length; j++){
					if(removed[j] == true){
						string += j + 1;
						System.out.print(j + 1);
					}
				}
				string += ",";
				System.out.print(",");
			}
			solutions.add(string);
			System.out.println();
		}
		reader.write(args[2], solutions);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");
	}
}
