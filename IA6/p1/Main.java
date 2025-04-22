// you may use this file to wrote and run code to test your code

public class Main {
    public static void main(String[] args) {
        // Test with Integer type
        testIntegerTree();
        
        // Test with String type
        testStringTree();
    }
    
    /**
     * Tests the MyBSTree with Integer values
     */
    private static void testIntegerTree() {
        System.out.println("===== Testing Integer BST =====");
        MyBSTree<Integer> intTree = new MyBSTree<>();
        
        // Insert some values
        System.out.println("Inserting values: 50, 30, 70, 20, 40, 60, 80");
        intTree.insert(50);
        intTree.insert(30);
        intTree.insert(70);
        intTree.insert(20);
        intTree.insert(40);
        intTree.insert(60);
        intTree.insert(80);
        
        // Test size
        System.out.println("Tree size: " + intTree.getSize());
        
        // Test in-order traversal
        System.out.print("In-order traversal: ");
        intTree.printInOrder();
        
        // Test toString
        System.out.println("toString(): " + intTree.toString());
        
        // Test contains
        System.out.println("Contains 40? " + intTree.containsItem(40));
        System.out.println("Contains 90? " + intTree.containsItem(90));
        
        // Test duplicate insertion
        System.out.println("Tree size before inserting duplicate: " + intTree.getSize());
        intTree.insert(40);  // Attempt to insert a duplicate
        System.out.println("Tree size after inserting duplicate: " + intTree.getSize());
        
        System.out.println();
    }
    
    /**
     * Tests the MyBSTree with String values
     */
    private static void testStringTree() {
        System.out.println("===== Testing String BST =====");
        MyBSTree<String> stringTree = new MyBSTree<>();
        
        // Insert some strings
        System.out.println("Inserting values: dog, cat, bird, ant, elephant, zebra");
        stringTree.insert("dog");
        stringTree.insert("cat");
        stringTree.insert("bird");
        stringTree.insert("ant");
        stringTree.insert("elephant");
        stringTree.insert("zebra");
        
        // Test size
        System.out.println("Tree size: " + stringTree.getSize());
        
        // Test in-order traversal
        System.out.print("In-order traversal: ");
        stringTree.printInOrder();
        
        // Test toString
        System.out.println("toString(): " + stringTree.toString());
        
        // Test contains
        System.out.println("Contains 'cat'? " + stringTree.containsItem("cat"));
        System.out.println("Contains 'tiger'? " + stringTree.containsItem("tiger"));
        
        System.out.println();
    }
}