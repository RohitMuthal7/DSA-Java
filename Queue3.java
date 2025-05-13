// Queue3.java
// Implementing a Queue using two Stacks (s1 and s2)

package Queue;
import java.util.*;

public class Queue3 {

    // Inner static class to define the Queue
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // Check if the queue is empty
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Add (enqueue) an element to the queue
        public static void add(int data) {
            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Push the new element into s1 (currently empty)
            s1.push(data);

            // Move all elements back from s2 to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Remove (dequeue) the front element from the queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty hai re baba");
                return -1;
            }
            return s1.pop(); // The top of s1 is the front of the queue
        }

        // Peek (get) the front element without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty hai re baba");
                return -1;
            }
            return s1.peek(); // Returns the front element
        }
    }

    // Main method to test the Queue
    public static void main(String[] args) {
        Queue q = new Queue();

        // Add elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);

        // Print and remove elements from the queue one by one
        while (!q.isEmpty()) {
            System.out.println(q.peek()); // Print front element
            q.remove(); // Remove front element
        }
    }
}
