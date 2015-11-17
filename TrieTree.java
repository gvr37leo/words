package main;

import java.util.ArrayList;
import java.util.Arrays;

public class TrieTree {
	private boolean exists = false;
	public int value;
	private TrieTree[] children = new TrieTree[26];
	
	public void insertList(ArrayList<String> list){
		for(int i = 0; i < list.size(); i++){
			this.insert(stringToIntArray(list.get(i)));
		}
	}
	
	public void insert(int[] word){
		insert(word, 0);
	}
	
	private void insert(int[] word,int current){
		if(word.length == current){
			exists = true;
			return;
		}
		int index = word[current];
		if(children[index] == null){
			children[index] = new TrieTree();
			children[index].value = index;
		}
		children[index].insert(word,current + 1);
	}
	
	public boolean exists(LinkedList string){
		if(string.getLength() == 0){
			return exists;
		}
		int index = string.get(0);
		if(children[index] == null){
			return false;
		}
		LinkedList linkedList = string.copy(1, string.getLength());
		return children[index].exists(linkedList);
	}
	
	public LinkedList findDeepestUnsorted(int[] word){
		return findDeepestUnsorted(word,new boolean[word.length]);
		
	}
	
	public LinkedList findDeepestUnsorted(int[] word,boolean[] used){
		LinkedList deepist = new LinkedList();
		if(allLettersUsed(used) && exists){
			return deepist;
		}else{
			int indexofDeepist = -1;
			boolean[] checked = new boolean[26];
			for(int i = 0; i < word.length; i++){
				if(used[i] == false){
					int currentLetter = word[i];
					if(currentLetter != -1 && children[currentLetter] != null && checked[currentLetter] == false){
						checked[currentLetter] = true;
						boolean[] newUsed = Arrays.copyOfRange(used, 0, used.length);
						newUsed[i] = true;
						LinkedList localDeepist = children[currentLetter].findDeepestUnsorted(word, newUsed);
						if(localDeepist.getLength() > deepist.getLength()){
							indexofDeepist = i;
							deepist = localDeepist;
						}
					}
				}
			}
			if(deepist.getLength() > 0 || exists){
				deepist.addFirst(indexofDeepist);
			}
			return deepist;
		}
	}
	
	private boolean allLettersUsed(boolean[] word){
		boolean allLettersUsed = true;
		for(int i = 0; i < word.length; i++){
			if(word[i] == false){
				allLettersUsed = false;
			}
		}
		return allLettersUsed;
	}
	
	public int[] stringToIntArray(String string){
		int[] array = new int[string.length()];
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < string.length(); i++){
			array[i] = alphabet.indexOf(string.charAt(i));
		}
		return array;
	}
}
