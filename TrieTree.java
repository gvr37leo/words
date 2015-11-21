package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class TrieTree {
	private int[] word;
	public int value;
	private TrieTree[] children = new TrieTree[26];
	
	
	
	public DLList findDeepest(int[] word){
		return findDeepest(word,0);
	}
	
	private DLList findDeepest(int[] word,int from){
		return null;
	}
	
	private int previousLetter(int[] word, int from, int index){
		if(index > from){
			return word[index - 1];
		}
		throw new NoSuchElementException();
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
}
