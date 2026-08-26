package dsa.queue.deque;

import io.swagger.models.auth.In;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();  // faster iteration, low memory, NO null allowed
        deque.addFirst(10);
        deque.addLast(20);
        deque.offerFirst(5);
        deque.offerLast(25);
        // 5, 10, 20, 25

        System.out.println(deque);
        System.out.println("First Element :: " +deque.getFirst()); // Outputs: 5
        System.out.println("Last Element :: " +deque.getLast()); // Outputs: 25

        deque.removeFirst(); // Removes: 5
        deque.pollLast();  // Removes: 25

        System.out.println("deque now: " + deque);








    }
}
