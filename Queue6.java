// 🔁 Interleave First and Second Half of a Queue (Even Length Only)
package Queue;
import java.util.*;

public class Queue6 {

    // Function to interleave the queue
    public static void interLeave(Queue<Integer> q) {
        // Temporary queue to store the first half
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        // Step 1: Store first half into firstHalf queue
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        // Step 2: Interleave firstHalf and secondHalf
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove()); // element from first half
            q.add(q.remove());         // element from second half
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // ⚠️ Use EVEN number of elements for interleaving
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        // q.add(11);  ← remove or comment this line for correct output

        interLeave(q);

        // Print the result
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
