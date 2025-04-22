import java.util.Queue;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        Node root = TreeTools.getRandomTree(10);
        TreeTools.printTree(root);
        
        int treeSum = sum(root);
        System.out.println("\nSum of all values in the tree: " + treeSum);
        
        int treeHeight = height(root);
        System.out.println("Height of the tree: " + treeHeight);
        
        int maxValue = max(root);
        System.out.println("Maximum value in the tree: " + maxValue);
        
        int targetValue = root.data;
        System.out.println("\nSearching for value " + targetValue + " using DFS:");
        boolean found = DFS(root, targetValue);
        System.out.println("\nValue " + targetValue + " found using DFS: " + found);
        
        System.out.println("\nSearching for value " + targetValue + " using BFS:");
        found = BFS(root, targetValue);
        System.out.println("\nValue " + targetValue + " found using BFS: " + found);
        
        int unlikelyValue = 999;
        System.out.println("\nSearching for value " + unlikelyValue + " using DFS:");
        found = DFS(root, unlikelyValue);
        System.out.println("\nValue " + unlikelyValue + " found using DFS: " + found);
        
        System.out.println("\nSearching for value " + unlikelyValue + " using BFS:");
        found = BFS(root, unlikelyValue);
        System.out.println("\nValue " + unlikelyValue + " found using BFS: " + found);
    }
    
    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        
        return node.data + sum(node.left) + sum(node.right);
    }
    
    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public static boolean DFS(Node node, int target) {
        if (node == null) {
            return false;
        }
        
        System.out.print(node.data + " ");
        
        if (node.data == target) {
            return true;
        }
        
        boolean foundInLeft = DFS(node.left, target);
        if (foundInLeft) {
            return true;
        }
        
        boolean foundInRight = DFS(node.right, target);
        return foundInRight;
    }
    
    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        
        int leftMax = max(node.left);
        int rightMax = max(node.right);
        
        return Math.max(node.data, Math.max(leftMax, rightMax));
    }
    
    public static boolean BFS(Node root, int target) {
        if (root == null) {
            return false;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.data == target) {
                return true;
            }
            
            if (current.left != null) {
                queue.add(current.left);
            }
            
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        
        return false;
    }
}