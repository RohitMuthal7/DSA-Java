package Queue;
import java.util.*;

public class Queue5 {

    // This method prints the first non-repeating character after each character in the input string
    public static void printNonRepeating(String str) {
        int freq[] = new int[26]; // Array to store frequency of characters from 'a' to 'z'
        Queue<Character> q = new LinkedList<>(); // Queue to keep track of characters in order of appearance

        // Loop through each character of the input string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // Get the current character
            q.add(ch); // Add the character to the queue
            freq[ch - 'a']++; // Increase its frequency in the frequency array

            // Remove characters from the front of the queue if their frequency is more than 1
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove(); // Remove repeated characters
            }

            // If queue is empty, no non-repeating character found yet
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                // The front of the queue is the first non-repeating character
                System.out.print(q.peek() + " ");
            }
        }

        System.out.println(); // Print a new line after processing all characters
    }

    // Main method to run the program
    public static void main(String[] args) {
        String str = "aabccxb"; // Input string
        printNonRepeating(str); // Call the method to print non-repeating characters
    }
}
