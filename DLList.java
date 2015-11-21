package main;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DLList{
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	public DLList(){
		head = new Node(-1, null, null);
		tail = new Node(-1, head, null);
		head.next = tail;
	}
	
	public DLList copy(int from, int to){
		DLList newList = new DLList();
    	
    	Node currentNode = this.get(from);
    	Node newCurrentNode = newList.head;
    	for (int i = 0; i < to - from; i++) {
    		newCurrentNode.next = new Node(currentNode.value, newCurrentNode, null);
    		newCurrentNode = newCurrentNode.next;
    		currentNode = currentNode.next;
		}
    	newCurrentNode = newList.tail;
    	newList.tail.previous = newCurrentNode;
    	newList.size = to - from;
    	return newList;
    }
	
	public void sort(){
		int[] array = this.arriyify();
		Arrays.sort(array);
		intArrayToThis(array);
	}
	
	public void intArrayToThis(int[] array){
		Node currentNode = head;
		size = 0;
    	for (int i = 0; i < array.length; i++) {
    		currentNode.next = new Node(array[i], currentNode, null);
			currentNode = currentNode.next;
			size++;
    	}
    	currentNode.next = tail;
    	tail.previous = currentNode;
	}
	
	public int[] arriyify(){
		int[] array = new int[size];
		Node current = head;
		for(int i = 0; current.hasNext(); i++){
			current = current.next;
			array[i] = current.value;
		}
		return array;
	}
	
	public void concat(int index, DLList list){
		Node occupier = get(index);
		occupier.next.previous = list.tail.previous;
		occupier.next = list.head.next;
	}
	
	public int indexOf(int needle){
		Node current = head;
		for(int i = 0; current.hasNext(); i++){
			current = current.next;
			if(current.value == needle){
				return i;
			}
		}
		return -1;
	}
	
	public Node get(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		if(index == 0 || size / index > 1){
			return getFromHead(index);
		}else{
			return getFromTail(index);
		}
	}
	
	public void insert(int index, int value){
		Node newNode;
		if (isEmpty()) {
			addFirst(value);
		}else{
			size++;
			Node occupier = get(index);
			newNode = new Node(value, occupier.previous, occupier);
			occupier.previous.next = newNode;
			occupier.previous = newNode;
		}
	}
	
	public Node remove(int index){
		size--;
		Node occupier = get(index);
		occupier.previous.next = occupier.next;
		occupier.next.previous = occupier.previous;
		return occupier;
	}
	
	public void addFirst(int value){
		size++;
		Node newNode = new Node(value, head, head.next);
		head.next = newNode.next;
		newNode.next.previous = newNode;
	}
	
	public Node removeFirst(){
		if(!isEmpty()){
			size--;
			Node temp = head.next;
			head.next = head.next.next;
			head.next.previous = head;
			return temp;
		}else{
			throw new NoSuchElementException();
		}
	}
	
	public void addLast(int value){
		size++;
		Node newNode = new Node(value, tail.previous, tail);
		tail.previous.next = newNode;
		tail.previous = newNode;
	}
	
	public Node removeLast(){
		if(!isEmpty()){
			size--;
			Node temp = tail.previous;
			tail.previous = tail.previous.previous;
			tail.previous.next = tail;
			return temp;
		}else{
			throw new NoSuchElementException();
		}
	}
	
	private Node getFromHead(int index){
		Node current = head;
		for (int i = 0; i <= index; i++) {
            current = current.next;
            if (i == index){
            	return current;
            }
		}
		return null;
	}
	
	private Node getFromTail(int index){
		Node current = tail;
		for(int i = size; i >= 0; i--){
			current = current.previous;
			if(i == index){
				return current;
			}
		}
		return null;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public class Node{
		private Node next;
		private Node previous;
		public int value;
		
		Node(int value, Node previous, Node next){
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
		
		boolean hasNext(){
			if(next != null && next != tail){
				return true;
			}
			return false;
		}
	}

}
