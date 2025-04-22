public class MyBSTree<T extends Comparable <T>> implements ITree<T> {
	// Private field for the root node
	private Node root;
	// Field to track the size of the tree
	private int size;
	// Flag to track if a duplicate was found during insertion
	private boolean duplicateFound;
	
	/**
	 * Constructor for MyBSTree
	 */
	public MyBSTree() {
		root = null;
		size = 0;
	}
	
	/**
	 * Inserts an item into the binary search tree
	 * @param item the item to insert
	 */
	@Override
	public void insert(T item) {
		// Reset the duplicate flag
		duplicateFound = false;
		
		// If the tree is empty, create a new root node
		if (root == null) {
			root = new Node(item);
			size++;
		} else {
			// Use the recursive insert method on the root
			root.insert(item);
			
			// Only increment size if no duplicate was found
			if (!duplicateFound) {
				size++;
			}
		}
	}
	
	/**
	 * Checks if the tree contains the specified item
	 * @param item the item to find
	 * @return true if the item is in the tree, false otherwise
	 */
	@Override
	public boolean containsItem(T item) {
		// If tree is empty, return false
		if (root == null) {
			return false;
		}
		
		// Start with root node
		Node current = root;
		
		// Loop until we find the item or reach a null node
		while (current != null) {
			// Compare the current node's data with the item
			int compareResult = item.compareTo(current.data);
			
			if (compareResult == 0) {
				// Item found
				return true;
			} else if (compareResult < 0) {
				// Item would be in left subtree
				current = current.left;
			} else {
				// Item would be in right subtree
				current = current.right;
			}
		}
		
		// Item not found
		return false;
	}
	
	/**
	 * Returns the number of nodes in the tree
	 * @return the size of the tree
	 */
	@Override
	public int getSize() {
		return size;
	}
	
	/**
	 * Prints the items in the tree in ascending order
	 */
	@Override
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	
	/**
	 * Helper method to recursively print the tree in-order
	 * @param node the current node
	 */
	private void printInOrder(Node node) {
		if (node != null) {
			// Visit left subtree
			printInOrder(node.left);
			// Print current node
			System.out.print(node.data + " ");
			// Visit right subtree
			printInOrder(node.right);
		}
	}
	
	/**
	 * Returns a string representation of the tree in ascending order
	 * @return a string with all items in ascending order
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		toStringHelper(root, result);
		
		// Remove the trailing space if the result is not empty
		if (result.length() > 0) {
			result.setLength(result.length() - 1);
		}
		
		return result.toString();
	}
	
	/**
	 * Helper method to recursively build the string representation
	 * @param node the current node
	 * @param result the StringBuilder to append to
	 */
	private void toStringHelper(Node node, StringBuilder result) {
		if (node != null) {
			// Visit left subtree
			toStringHelper(node.left, result);
			// Append current node
			result.append(node.data).append(" ");
			// Visit right subtree
			toStringHelper(node.right, result);
		}
	}
	
	/**
	 * Nested inner class for nodes in the binary search tree
	 */
	class Node {
		// Public fields as required
		public T data;
		public Node left;
		public Node right;
		
		/**
		 * Constructor for Node
		 * @param data the data to store in this node
		 */
		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		/**
		 * Recursively inserts an item into the subtree rooted at this node
		 * @param item the item to insert
		 */
		public void insert(T item) {
			// Compare the item with this node's data
			int compareResult = item.compareTo(data);
			
			if (compareResult == 0) {
				// Item is already in the tree (duplicate)
				// Set the duplicate flag so we don't increment size
				duplicateFound = true;
				return;
			} else if (compareResult < 0) {
				// Item should go in left subtree
				if (left == null) {
					// Create new node as left child
					left = new Node(item);
				} else {
					// Recursively insert in left subtree
					left.insert(item);
				}
			} else {
				// Item should go in right subtree
				if (right == null) {
					// Create new node as right child
					right = new Node(item);
				} else {
					// Recursively insert in right subtree
					right.insert(item);
				}
			}
		}
	}
}