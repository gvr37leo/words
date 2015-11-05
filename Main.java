package main;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Reader reader = new Reader();
		ArrayList<String> dictionaryLines = reader.read("dictionary.txt");
		ArrayList<String> puzzleLines = reader.read("puzzles.txt");

		Pyramid pyramid = new Pyramid();
		pyramid.insertArrayListString(puzzleLines, 0, 8);
		
		TrieTree trieTree = new TrieTree();
		trieTree.value = -1;
		trieTree.insertList(dictionaryLines);// gaat iets fout alleean de eerste rij lijkt geinsert te worden
		
		for(int i = 0; i < 6; i++){
			LinkedList bottom = new LinkedList();
			bottom.intArrayToThis(pyramid.getBottom());
			LinkedList biggestWord = trieTree.findDeepest(bottom);
			System.out.println(biggestWord.stringify());
			pyramid.removeArray(biggestWord.arrayifi());
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
