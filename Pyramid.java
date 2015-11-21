package main;

import java.util.ArrayList;

public class Pyramid {
	DLList[] columns = new DLList[9];
	
	public Pyramid(){
		for (int i = 0; i < columns.length; i++) {
			columns[i] = new DLList();
		}
	}
	
	public void removeLocations(int[] array){
		for(int i = 0; i < array.length; i++){
			columns[array[i]].removeFirst();
		}
	}
	
	public boolean[] removeArray(int[] array){
		int[] bottom = getBottom();
		boolean[] found = new boolean[columns.length];
		for(int i = 0; i < array.length; i++){
			int index = indexOfUnfound(array[i], bottom, found);
			if(index != -1){
				columns[index].removeFirst();
				found[index] = true;
			}
		}
		return found;
	}
	
	public void insertString(String string){
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < columns.length && i < string.length(); i++) {
			int currentChar = alphabet.indexOf(string.charAt(i));
			if (currentChar != -1) {
				columns[i].addFirst(currentChar); 
			}
		}
	}
	
	public void insertArrayListString(ArrayList<String> list, int from, int to){
		for (int i = from; i < to; i++) {
			this.insertString(list.get(i));  
		}
	}
	
	public int indexOfUnfound(int needle,int[] array,boolean[] found){
		for(int i = 0; i < array.length; i++){
			if(needle == array[i] && found[i] == false){
				return i;
			}
		}
		return -1;
	}
	
	public int[] getBottom(){
		int[] bottom = new int[columns.length];
		for(int i = 0; i < columns.length; i++){
			bottom[i] = columns[i].get(0).value;
		}
		return bottom;
	}
}
