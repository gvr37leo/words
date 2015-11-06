package main;

import java.util.ArrayList;

public class Pyramid {
	Stack[] columns = new Stack[9];
	
	public Pyramid(){
		for (int i = 0; i < columns.length; i++) {
			columns[i] = new Stack();
		}
	}
	
	public void removeArray(int[] array){
		int[] bottom = getBottom();
		boolean[] found = new boolean[columns.length];
		for(int i = 0; i < array.length; i++){
			int index = indexOfUnfound(array[i], bottom, found);
			if(index != -1){
				columns[index].pop();
				found[index] = true;
			}
		}
	}
	
	public void insertString(String string){
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < columns.length && i < string.length(); i++) {
			int currentChar = alphabet.indexOf(string.charAt(i));
			if (currentChar != -1) {
				columns[i].push(currentChar); 
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
			bottom[i] = columns[i].top();
		}
		return bottom;
	}
}
