// Complete the implementation of your MyArrayList class in this file
import java.util.NoSuchElementException;

public class MyQueue implements IQueue {
	// Private inner class for linked list nodes
	private class Node {
		Object data;
		Node next;
		
		Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// Fields
	private Node front;
	private Node rear;
	private int size;
	
	// Constructor
	public MyQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	@Override
	public void enqueue(Object item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			front = newNode;
		} else {
			rear.next = newNode;
		}
		rear = newNode;
		size++;
	}

	@Override
	public Object dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		Object item = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		return item;
	}

	@Override
	public Object peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		return front.data;
	}

	@Override
	public int indexOf(Object item) {
		Node current = front;
		int index = 0;
		while (current != null) {
			if (current.data.equals(item)) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// add any necessary methods or classes below

}
