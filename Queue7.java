// Program: Reverse a Queue using a Stack
// This program demonstrates how to reverse the elements of a queue using a stack in Java.
// It uses Java's built-in LinkedList for Queue and Stack classes for stack operations.

package Queue;
import java.util.*;

public class Queue7 {

    // Function to reverse the elements of a queue
    public static void Reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();  // Create a stack to assist in reversing

        // Step 1: Remove all elements from the queue and push them onto the stack
        while (!q.isEmpty()) {
            s.push(q.remove());  // Remove from queue and push into stack
        }

        // Step 2: Pop all elements from the stack and add them back to the queue
        while (!s.isEmpty()) {
            q.add(s.pop());  // Pop from stack and add back to queue
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();  // Create a queue using LinkedList

        // Adding elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        // Call the reverse function to reverse the queue
        Reverse(q);

        // Print the reversed queue
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
