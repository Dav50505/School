class TreeTools {
    /**
     * Generates a random binary tree with the specified number of nodes.
     * Each Node will have an int value between 0 and 99 (inclusive)
     *
     * @param nodeCount The number of nodes in the generated tree.
     * @return The root node of the generated binary tree.
     *         Returns null if nodeCount is less than 1.
     */
    public static Node getRandomTree(int nodeCount) {
        if (nodeCount < 1)
            return null;

        Node root = new Node((int) (Math.random() * 100));

        while (nodeCount > 1) {
            insert(root, (int) (Math.random() * 100));
            nodeCount--;
        }

        return root;
    }

    /**
     * Prints a representation of a binary tree.
     *
     * @param The root node of the binary tree to be printed.
     */
    public static void printTree(Node root) {
        printTree(root, null, false);
    }

    private static void insert(Node node, int value) {
        if (Math.random() < 0.5) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    private static void showTrunks(Trunk p) {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

    private static void printTree(Node root, Trunk prev, boolean isLeft) {
        if (root == null) {
            return;
        }

        String prev_str = "     ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.right, trunk, true);

        if (prev == null) {
            trunk.str = "--{";
        } else if (isLeft) {
            trunk.str = "/--{";
            prev_str = "    |";
        } else {
            trunk.str = "\\--{";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println("" + root.data + "}");

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "    |";

        printTree(root.left, trunk, false);
    }
}

class Trunk {
    Trunk prev;
    String str;

    Trunk(Trunk prev, String str) {
        this.prev = prev;
        this.str = str;
    }
}