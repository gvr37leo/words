package main;

import java.util.ArrayList;

public class TrieTree {
	private boolean exists = false;
	public int value;
	private TrieTree[] children = new TrieTree[26];
	
	public void insertList(ArrayList<String> list){
		for(int i = 0; i < list.size(); i++){
			LinkedList newLinkedList = new LinkedList();
			newLinkedList.stringToThis(list.get(i));
			newLinkedList.sort();
			this.insert(newLinkedList);
		}
	}
	
	public void insert(LinkedList string){
		if(string.getLength() == 0){
			exists = true;
			return;
		}
		int index = string.get(0);
		if(children[index] == null){
			children[index] = new TrieTree();
			children[index].value = index;
		}
		LinkedList linkedList = string.copy(1, string.getLength());
		children[index].insert(linkedList);
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
	
	public LinkedList findDeepest(int[] word,int from){
		LinkedList deepist = new LinkedList();
		int wordlength = word.length - from;
		if(wordlength == 0){
			if(exists  && value != -1){
				deepist.addFirst(value);
			}
			return deepist;
		}else{
//			1,4,4,9,11,14,19 / 1,2,3,4,5,6 | 1,2,3,4 / 1,4,4,9
			for(int i = from; i < word.length; i++){
				int currentLetter = word[i];
				if(currentLetter != -1 && children[currentLetter] != null){
					LinkedList localDeepist = children[currentLetter].findDeepest(word,from + 1);
					if(localDeepist.getLength() > deepist.getLength()){
						deepist = localDeepist;
					}
				}
			}
			if((deepist.getLength() > 0 || exists) && value != -1 ){
				deepist.addFirst(value);
			}
			return deepist;	
		}
	}
}
