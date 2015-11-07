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
	
	public LinkedList findDeepest(LinkedList word){
		if(word.getLength() == 0){
			LinkedList newLinkedList = new LinkedList();//same
			if(exists  && value != -1){
				newLinkedList.addFirst(value);
			}
			return newLinkedList;
		}else{
			LinkedList deepist = new LinkedList();//same
			for(int i = 0; i < word.getLength(); i++){
				int currentLetter = word.get(i);
				if(children[currentLetter] != null){
					LinkedList smallerWord = word.copy(i + 1, word.getLength());
					LinkedList localDeepist = children[currentLetter].findDeepest(smallerWord);
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
