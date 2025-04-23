// Implement the structure of the MyString class here

public class MyString {
    // Private instance variables
    private int capacity;
    private int length;
    private char[] data;
    
    // Default constructor
    public MyString() {
        this.capacity = 16;
        this.length = 0;
        this.data = new char[capacity];
    }
    
    // Constructor with int parameter
    public MyString(int capacity) {
        this.capacity = Math.max(16, capacity);
        this.length = 0;
        this.data = new char[this.capacity];
    }
    
    // Constructor with String parameter
    public MyString(String text) {
        this.capacity = Math.max(16, text.length());
        this.length = text.length();
        this.data = new char[this.capacity];
        for (int i = 0; i < text.length(); i++) {
            this.data[i] = text.charAt(i);
        }
    }
    
    // Method to get character at specified index
    public char charAt(int index) {
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException();
        }
        return data[index];
    }
    
    // Method to concatenate with another MyString
    public void concat(MyString text) {
        int newLength = this.length + text.length();
        if (newLength > capacity) {
            makeCapacity(newLength);
        }
        for (int i = 0; i < text.length(); i++) {
            this.data[this.length + i] = text.charAt(i);
        }
        this.length = newLength;
    }
    
    // Method to check if two MyString objects are equal
    public boolean equals(MyString text) {
        if (this.length != text.length()) {
            return false;
        }
        for (int i = 0; i < this.length; i++) {
            if (this.data[i] != text.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    // Method to find index of a MyString within this MyString
    public int indexOf(MyString text) {
        if (text.length() > this.length) {
            return -1;
        }
        for (int i = 0; i <= this.length - text.length(); i++) {
            boolean found = true;
            for (int j = 0; j < text.length(); j++) {
                if (this.data[i + j] != text.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
    
    // Method to get the length of the MyString
    public int length() {
        return length;
    }
    
    // Method to set the capacity of the MyString
    public void makeCapacity(int capacity) {
        if (capacity < this.length) {
            return;
        }
        char[] newData = new char[capacity];
        for (int i = 0; i < this.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
        this.capacity = capacity;
    }
    
    // Method to store a MyString
    public void store(MyString text) {
        if (text.length() > capacity) {
            makeCapacity(text.length());
        }
        for (int i = 0; i < text.length(); i++) {
            this.data[i] = text.charAt(i);
        }
        this.length = text.length();
    }
    
    // Method to store a String
    public void store(String text) {
        if (text.length() > capacity) {
            makeCapacity(text.length());
        }
        for (int i = 0; i < text.length(); i++) {
            this.data[i] = text.charAt(i);
        }
        this.length = text.length();
    }
    
    // Method to get a substring
    public MyString substring(int start, int end) {
        if (start < 0 || start >= length || end < start || end > length) {
            throw new StringIndexOutOfBoundsException();
        }
        MyString result = new MyString(end - start);
        for (int i = start; i < end; i++) {
            result.data[i - start] = this.data[i];
        }
        result.length = end - start;
        return result;
    }
    
    // Method to convert MyString to String
    @Override
    public String toString() {
        return new String(data, 0, length);
    }
}