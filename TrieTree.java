package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class TrieTree {
	private int[] word;
	public int value;
	private TrieTree[] children = new TrieTree[26];
	
	public int[] findDeepest(int[] word){
		return findDeepest(word,0);
	}
	
	private int[] findDeepest(int[] word,int from){
		int[] deepist = new int[0];
		if(word.length - from == 0){
			if(word != null){
				return this.word;
			}
		}else{
			for(int i = from; i < word.length; i++){
				int currentLetter = word[i];
				int previousLetter = previousLetter(word, from, i);
				if(currentLetter != -1 && children[currentLetter] != null && currentLetter != previousLetter){
					int[] localDeepist = children[currentLetter].findDeepest(word, from + 1);
					if(localDeepist.length > deepist.length){
						deepist = localDeepist;
					}
				}
			}
		}
		return deepist;
	}
	
	private int previousLetter(int[] word, int from, int index){
		if(index > from){
			return word[index - 1];
		}
		throw new NoSuchElementException();
	}
	
	public void insertList(ArrayList<String> list, int maxSize){
		for(int i = 0; i < list.size(); i++){
			String string = list.get(i);
			if(string.length() < maxSize){
				int[] array = stringToIntArray(string);
				Arrays.sort(array);
				insert(array);
			}
		}
	}
	
	public void insert(int[] word){
		insert(word, 0);
	}
	
	public void insert(int[] word, int from){
		if(word.length - from == 0){
			this.word = word;
			return;
		}
		int index = word[from];
		if(children[index] == null){
			children[index] = new TrieTree();
			children[index].value = index;
		}
		children[index].insert(word, from + 1);
	}
	
	public boolean exists(int[] word, int from){
		if(word.length - from == 0){
			return word != null;
		}
		int index = word[from];
		if(children[index] == null){
			return false;
		}
		return children[index].exists(word, from + 1);
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
