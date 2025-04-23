// Complete the implementation of your MyArrayList class in this file

import java.util.NoSuchElementException;

public class MyArrayList implements MyList {
    private int capacity = 8;
    private int size = 0;
    private Object[] storage = new Object[8];

    public void addToEnd(Object o) {
        if (size == capacity) {
            makeCapacity(2 * capacity);
        }
        storage[size] = o;
        size++;
    }

    public void insertAt(int index, Object o) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException();
        }
        if (size == capacity) {
            makeCapacity(2 * capacity);
        }
        // Shift elements to make room for the new element
        for (int i = size; i > index; i--) {
            storage[i] = storage[i - 1];
        }
        storage[index] = o;
        size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        // Shift elements to fill the gap
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null; // Clear the last element
        size--;
    }

    public Object getAt(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        return storage[index];
    }

    public int getSize() {
        return size;
    }

    public void makeCapacity(int minCapacity) {
        if (minCapacity <= size || minCapacity == capacity) {
            return;
        }
        int newCapacity = Math.max(8, minCapacity);
        Object[] newStorage = new Object[newCapacity];
        // Copy elements to the new array
        for (int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }
        storage = newStorage;
        capacity = newCapacity;
    }

    public void trimExcess() {
        makeCapacity(size);
    }

    public MyListIterator getIterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements MyListIterator {
        private int currentIndex = -1;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            currentIndex++;
            return storage[currentIndex];
        }
    }
}