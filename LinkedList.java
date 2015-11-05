package main;

import java.util.Arrays;

public class LinkedList
    {
        private Node head = new Node(-1,null);
        private int length;

        public int get(int index)
        {
            Node current = head.next;
            for (int i = 0; i <= length && current!= null; i++)
            {
                if (i == index)
                {
                    return current.value;
                }
                current = current.next;
            }
            return -1;
        }
        
        public Node getNode(int index)
        {
            Node current = head.next;
            for (int i = 0; i <= length && current!= null; i++)
            {
                if (i == index)
                {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public void insert(int index,int value)
        {
            length++;
            Node previous;
            Node current = head;
            for (int i = 0; i <= index && current != null; i++)
            {
                previous = current;
                current = current.next;
                if (i == index)
                {
                    previous.next = new Node(value,current);
                    return;
                }
            }
        }

        public void addFirst(int value)
        {
            this.insert(0, value);
        }

        public void remove(int index)
        {
            length--;
            Node previous;
            Node current = head;
            for (int i = 0; i <= index && current != null; i++)
            {
                previous = current;
                current = current.next;
                if (i == index)
                {
                    previous.next = current.next;
                    return;
                }
            }
        }

        public void removeFirst()
        {
            this.remove(0);
        }

        public int getLength()
        {
            return length;
        }
        
        public void concat(LinkedList other){
        	Node last = getNode(length - 1);
        	last.next = other.getNode(0);
        	length += other.length;
        }
        
        public int indexOf(int value){
        	Node current = getNode(0);
        	for(int i = 0; i < length; i++){
        		if(current.value == value){
        			return i;
        		}
        		current = current.next;
        	}
        	return -1;
        }
        
        public void intArrayToThis(int[] array){
        	Node currentNode = head;
        	length = 0;
        	for (int i = 0; i < array.length; i++) {
        		if(array[i] != -1){// this is ugly since -1 is just a normal number altough it shouldnt appear in this program
        			currentNode.next = new Node(array[i], null);
    				currentNode = currentNode.next;
    				length++;
        		}
        	}
        }
        
        public LinkedList copy(int from, int to){
        	LinkedList newLinkedList = new LinkedList();
        	
        	Node currentNode = this.getNode(from);
        	Node newCurrentNode = newLinkedList.head;
        	for (int i = 0; i < to - from; i++) {
        		newCurrentNode.next = new Node(currentNode.value,null);
        		newCurrentNode = newCurrentNode.next;
        		currentNode = currentNode.next;
			}
        	newLinkedList.length = to - from;
        	return newLinkedList;
        }
        
        public void sort(){
        	int[] array = this.arrayifi();
        	Arrays.sort(array);
        	this.intArrayToThis(array);
        }
        
        public void stringToThis(String string){
        	String alphabet = "abcdefghijklmnopqrstuvwxyz";
    		Node currentNode = this.head;
    		length = 0;
    		for(int i = 0; i < string.length(); i++){
    			int charnumber = alphabet.indexOf(string.charAt(i));
    			currentNode.next = new Node(charnumber, null);
    			currentNode = currentNode.next;
    		}
    		length = string.length();
        }
        
        public String stringify(){
        	String alphabet = "abcdefghijklmnopqrstuvwxyz";
        	int[] array = this.arrayifi();
        	String string = "";
        	for (int i : array) {
				string = string + alphabet.charAt(i);
			}
        	return string;
        }
        
        public int[] arrayifi(){
        	int[] array = new int[length];
        	Node currentNode = head.next;
        	for(int i = 0; currentNode != null; i++){
        		array[i] = currentNode.value;
        		currentNode = currentNode.next;
        	}
			return array;
        }

        public class Node
        {
            private Node next;
            public int value;

            public Node(int value, Node node)
            {
                this.next = node;
                this.value = value;
            }
        }
    }
