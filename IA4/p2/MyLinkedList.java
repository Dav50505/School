// Complete the implementation of your MyLinkedList class in this file

import java.util.NoSuchElementException;

public class MyLinkedList implements MyList {
    private Node head = null;
    private int size = 0;
    
    @Override
    public void addToEnd(Object o) {
        Node newNode = new Node();
        newNode.data = o;
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    @Override
    public void insertAt(int index, Object o) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException();
        }
        
        Node newNode = new Node();
        newNode.data = o;
        
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    
    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
    
    @Override
    public Object getAt(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    @Override
    public int getSize() {
        return size;
    }
    
    // Do not alter the code below 
    
    public MyListIterator getIterator() {
        return new MyLinkedListIterator();
    }
    
    private class MyLinkedListIterator implements MyListIterator {
        Node currentNode = null;

        @Override
        public Object next() {
            if (currentNode != null)
                currentNode = currentNode.next;
            else
                currentNode = head;

            return currentNode.data;
        }

        @Override
        public boolean hasNext() {
            if (currentNode != null)
                return currentNode.next != null;
            else
                return head != null;
        }
    }
    
    class Node {
        public Object data = null;
        public Node next = null;
    }
}