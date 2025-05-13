package Queue;

public class Queue0 {

    // Static inner class to define our Queue
    static class Queue {
        // Array to store queue elements
        static int arr[];
        // Maximum size of the queue
        static int size;
        // Index of the last element in the queue
        static int rear;

        // Constructor to initialize the queue
        Queue(int n) {
            arr = new int[n];  // Create array of size 'n'
            size = n;          // Set the maximum size
            rear = -1;         // Initially queue is empty, so rear is -1
        }

        // Check if the queue is empty
        public static boolean isEmpty() {
            return rear == -1;
        }

        // Add (enqueue) an element to the queue
        public static void add(int data) {
            // If the queue is full
            if (rear == size - 1) {
                System.out.println("Queue is Full");
                return;
            }

            // Move rear forward and add the element
            rear = rear + 1;
            arr[rear] = data;
        }

        // Remove (dequeue) the front element from the queue
        public static int remove() {
            // If queue is empty
            if (isEmpty()) {
                System.out.println("Empty Hai");
                return -1;
            }

            // Store the front element to return it later
            int front = arr[0];

            // Shift all elements one step to the left
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            // Decrease rear after removing an element
            rear = rear - 1;

            return front;  // Return the removed front element
        }

        // Peek: Get the front element without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Hai");
                return -1;
            }
            return arr[0];  // Front of the queue is always at index 0
        }
    }

    // Main method to test the queue
    public static void main(String[] args) {
        // Create a queue of size 5
        Queue q = new Queue(5);

        // Add elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);

        // Remove and print all elements from the queue
        while (!q.isEmpty()) {
            System.out.println("Queue : "+q.peek());  // Print front element
            q.remove();                    // Remove front element
        }
    }
}
