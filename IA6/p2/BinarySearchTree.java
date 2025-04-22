public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }

        int compareResult = data.compareTo(root.data);
        if (compareResult < 0) {
            root.left = insertRec(root.left, data);
        } else if (compareResult > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public T search(T key) {
        return searchRec(root, key);
    }

    private T searchRec(Node<T> root, T key) {
        if (root == null || key.compareTo(root.data) == 0) {
            return root != null ? root.data : null;
        }

        if (key.compareTo(root.data) < 0) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    public T findMax() {
        if (root == null) {
            return null;
        }
        
        return findMaxRec(root);
    }

    private T findMaxRec(Node<T> node) {
        if (node.right == null) {
            return node.data;
        }
        return findMaxRec(node.right);
    }

    public T findMin() {
        if (root == null) {
            return null;
        }
        
        return findMinRec(root);
    }

    private T findMinRec(Node<T> node) {
        if (node.left == null) {
            return node.data;
        }
        return findMinRec(node.left);
    }

    public void inOrderTraversal(NodeVisitor<T> visitor) {
        inOrderRec(root, visitor);
    }

    private void inOrderRec(Node<T> root, NodeVisitor<T> visitor) {
        if (root != null) {
            inOrderRec(root.left, visitor);
            visitor.visit(root.data);
            inOrderRec(root.right, visitor);
        }
    }

    // Interface for processing nodes during traversal
    public interface NodeVisitor<T> {
        void visit(T data);
    }
} 