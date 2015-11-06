package main;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Reader reader = new Reader();
		ArrayList<String> dictionaryLines = reader.read("dictionary.txt");
		ArrayList<String> puzzleLines = reader.read("puzzles.txt");

		TrieTree trieTree = new TrieTree();
		trieTree.value = -1;// ugly thing has due to weirdish implementation of trietree
		trieTree.insertList(dictionaryLines);
		
		for(int i = 0; i < 10; i++){
			Pyramid pyramid = new Pyramid();
			pyramid.insertArrayListString(puzzleLines, i * 8, i * 8 + 8);
			
			int[] empty = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
			String string = "";
			while(!Arrays.equals(pyramid.getBottom(), empty)){
				LinkedList bottom = new LinkedList();
				bottom.intArrayToThis(pyramid.getBottom());
				LinkedList biggestWord = trieTree.findDeepest(bottom);
				
				System.out.println(biggestWord.stringify());//vindt positie van letters net zoals in removearray
				pyramid.removeArray(biggestWord.arrayifi());
			}
			System.out.println();
		}
		
		
		
		
//		LinkedList word = new LinkedList();
//		word.stringToThis("namsiumgyqm");
//		word.sort();
//		System.out.println(trieTree.findDeepest(word).stringify());
//		
//		ArrayList<String> solutions = new ArrayList<String>();
//		solutions.add("abg");
//		solutions.add("def");
//		reader.write("solutions.txt", solutions);
	}
}
