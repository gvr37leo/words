package main;
public class Stack
    {
        private LinkedList linkedList = new LinkedList();

        public void push(int value)
        {
            linkedList.addFirst(value);
        }

        public int pop()
        {
            int temp = linkedList.get(0);
            linkedList.removeFirst();
            return temp;
        }

        public int top()
        {
            return linkedList.get(0);
        }
    }