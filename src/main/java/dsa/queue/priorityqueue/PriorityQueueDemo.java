package dsa.queue.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // part of the Queue interface
        // Orders element based on their natural ordering (For primitives, lowest first)
        // Custom Comparator for customised ordering
        // Does not allow null elements

   //     PriorityQueue<Integer> pq = new PriorityQueue<>();
 //     PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
      PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> x-y);                 // Ascending order
        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(5);

        System.out.println("pq ::: " +pq);  // Not sorted



    }
}
