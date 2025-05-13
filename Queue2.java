package Queue;

public class Queue2 {

    // Node class representing each element in the Queue
    static class Node {
        int data;       // To store the value
        Node next;      // Reference to the next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue class to manage the queue operations
    static class Queue {
        static Node head = null; // Front of the queue
        static Node tail = null; // Rear of the queue

        // Check if the queue is empty
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Add an element to the queue (enqueue)
        public static void add(int data) {
            Node newNode = new Node(data); // Create a new node
            if (head == null) {
                // If queue is empty, new node becomes head and tail
                head = tail = newNode;
                return;
            }
            // Attach new node at the end and update tail
            tail.next = newNode;
            tail = newNode;
        }

        // Remove an element from the front of the queue (dequeue)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty haiiii");
                return -1;
            }
            int front = head.data; // Store the front value to return
            if (head == tail) {
                // If only one element was in the queue
                head = tail = null;
            } else {
                // Move head to next node
                head = head.next;
            }
            return front;
        }

        // Peek at the front element without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty haiiii");
                return -1;
            }
            return head.data;
        }
    }

    // Main method to test the queue
    public static void main(String[] args) {
        Queue q = new Queue();

        // Adding elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);

        // Removing and printing elements from the queue
        while (!q.isEmpty()) {
            System.out.println(q.peek()); // Show front
            q.remove();                   // Remove front
        }
    }
}
