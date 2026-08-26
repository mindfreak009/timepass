package dsa.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// OUTPUT :  {F E C B A}
public class Notes {

    //  Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner

    //  offer() : method inserts an element  if possible, without violating capacity restrictions, otherwise returns false.
    // 	remove() : Retrieves and removes the head of this queue.
    //  poll()   : Retrieves and removes the head of this queue, or returns NULL if this queue is empty.
    //  peek()   : Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.

    // Queue implementations generally do not allow insertion of null elements, although some implementations, such as LinkedList,
    // DO NOT PROHIBIT insertion of null.

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer("Bombay");
        queue.offer("Calcutta");
        queue.offer("Amsterdam");
        queue.offer("France");
        queue.offer("England");

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}
