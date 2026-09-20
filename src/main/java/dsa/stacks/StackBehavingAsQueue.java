package dsa.stacks;

import java.util.Stack;

// Time Complexity - O(N)
// Space Complexity - 0(2N)

// Stack behaves LIFO
// Queue behaves FIFO
public class StackBehavingAsQueue {

    static class Queue {
        static  Stack<Integer> s1 = new Stack<Integer>();
        static  Stack<Integer> s2 = new Stack<Integer>();

        // Method
        static void enQueue(int x) {
            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Push item into s1
            s1.push(x);

            // Push everything back to s1
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        static int deQueue() {

            // if first stack is empty
            if (s1.isEmpty()) {
                return -1;
            }

            // Return top of s1
            int s = s1.peek();
            s1.pop();

            return s;
        }
    };


    public static void main(String[] args) {
        Queue.enQueue(1);
        Queue.enQueue(2);
        Queue.enQueue(3);

        System.out.println("stack1 :: " +Queue.s1);
        System.out.println("stack2 :: " +Queue.s2);
       // System.out.println(Queue.deQueue());
       // System.out.println(Queue.deQueue());
       // System.out.println(Queue.deQueue());
    }
}
