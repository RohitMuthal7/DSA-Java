// Stack using Two Queues (Queue to Stack Conversion)
package Queue;

import java.util.*;

public class Queue4 {

    // Stack class banai hai jisme hum 2 queues ka use karenge
    static class Stack {
        // Do queues banayi - q1 and q2
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // Check karta hai ki dono queues empty hai ya nahi
        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // Stack mein element push karna
        public static void push(int data) {
            // Agar q1 empty nahi hai to usme data daalo
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                // Agar q1 empty hai to q2 me data daalo
                q2.add(data);
            }
        }

        // Stack se element nikalna (pop operation)
        public static int pop() {
            // Agar stack empty hai to error message do
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            int top = -1; // yeh variable last element ko store karega

            // Case 1: agar q1 me elements hai
            if (!q1.isEmpty()) {
                // Jab tak q1 me ek hi element nahi bacha tab tak:
                while (!q1.isEmpty()) {
                    top = q1.remove(); // ek element nikalo
                    if (q1.isEmpty()) {
                        // agar yeh last element hai to break karo
                        break;
                    }
                    q2.add(top); // baki elements q2 me daal do
                }
            } else {
                // Case 2: agar q2 me elements hai
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }

            // last element return kar do (stack ka top)
            return top;
        }

        // Stack ke top element ko dekhna bina nikaale (peek operation)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            int top = -1;

            // Case 1: agar q1 me elements hai
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();   // element nikalo
                    q2.add(top);        // usko q2 me daal do
                }
            } else {
                // Case 2: agar q2 me elements hai
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }

            // top element return karo (lekin remove nahi hua)
            return top;
        }
    }

    // Main method - program start yahan se hota hai
    public static void main(String[] args) {
        Stack s = new Stack();  // Stack object banaya

        s.push(1);  // stack me 1 daala
        s.push(2);  // stack me 2 daala
        s.push(3);  // stack me 3 daala

        // Jab tak stack empty nahi hota
        while (!s.isEmpty()) {
            System.out.println(s.peek());  // top element dekho
            s.pop();                       // usko hata do
        }
    }
}
