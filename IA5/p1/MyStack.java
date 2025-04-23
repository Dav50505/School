import java.util.NoSuchElementException;

public class MyStack implements IStack {
	private Node top;
	private int size;

	private class Node {
		Object data;
		Node next;

		Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}

	@Override
	public void push(Object item) {
		Node newNode = new Node(item);
		newNode.next = top;
		top = newNode;
		size++;
	}

	@Override
	public Object pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		Object item = top.data;
		top = top.next;
		size--;
		return item;
	}

	@Override
	public Object peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		return top.data;
	}

	@Override
	public int indexOf(Object item) {
		Node current = top;
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
