package Queue;

public class Queue1 {
    static class Queue {
        static int arr[];       // Queue ko store karne ke liye array
        static int size;        // Queue ka size
        static int rear;        // Rear pointer (element add hota hai yahan)
        static int front;       // Front pointer (element remove hota hai yahan)

        // Constructor: queue ko initialize karta hai
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;   // rear starting mein -1 (queue empty)
            front = -1;  // front bhi -1 (queue empty)
        }

        // Queue empty hai ya nahi
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // Queue full hai ya nahi
        public static boolean isFull() {
            return (rear + 1) % size == front;
            // Agar rear aage badhkar front pe aa gaya (circularly), to queue full hai
        }

        // Add karne ka function (enqueue)
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Full Hogaya");
                return;
            }

            if (front == -1) {
                front = 0; // Pehla element add ho raha hai to front 0 karna hoga
            }

            rear = (rear + 1) % size;  // rear ko circular way mein badhao
            arr[rear] = data;          // element ko queue mein add karo
        }

        // Remove karne ka function (dequeue)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty hai");
                return -1;
            }

            int result = arr[front]; // front pe jo element hai usko store karo

            if (rear == front) {
                // Sirf ek hi element tha, usko hata ke queue empty ho gaya
                rear = front = -1;
            } else {
                front = (front + 1) % size;  // front ko circularly aage badhao
            }

            return result;
        }

        // Peek: front pe jo element hai, usko dekho bina remove kiye
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);  // Queue ka size 5

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());  // 1 remove hoga
        q.add(4);                        // 4 add hoga

        System.out.println(q.remove());  // 2 remove hoga
        q.add(5);                        // 5 add hoga

        // Queue ke sabhi elements print karte hue remove karo
        while (!q.isEmpty()) {
            System.out.println(q.peek()); // current front print karo
            q.remove();                   // front element remove karo
        }
    }
}
