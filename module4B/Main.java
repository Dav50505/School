public class Main {
    // Add a new node at the front of the list
    public static Node addAtFront(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    // Print the list in the required format
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("{}");
            return;
        }

        System.out.print("{");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("}");
    }

    // Get the size of the list
    public static int getSize(Node head) {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // Add a new node at the end of the list
    public static Node addToEnd(Node head, int value) {
        Node newNode = new Node(value);
        
        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    // Remove the first node from the list
    public static Node removeFromFront(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    // Remove the last node from the list
    public static Node removeFromEnd(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }

    // Insert a new node at the specified index
    public static Node insertAtIndex(Node head, int index, int value) {
        Node newNode = new Node(value);

        if (index == 0) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            return head; // Index out of bounds
        }

        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    // Remove the node at the specified index
    public static Node removeAtIndex(Node head, int index) {
        if (head == null || index < 0) {
            return head;
        }

        if (index == 0) {
            return head.next;
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null || current.next == null) {
            return head; // Index out of bounds
        }

        current.next = current.next.next;
        return head;
    }
} 