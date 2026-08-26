package dsa.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        System.out.println(queue.size());

        System.out.println(queue.remove()); // throws Exception, if empty
        System.out.println(queue.poll());

        System.out.println(queue.element()); // throws Exception, if empty
        System.out.println(queue.peek());

        // =======================================================================
        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);
        System.out.println(queue2.add(1));  // true
        System.out.println(queue2.offer(1));  // true

        System.out.println(queue2.offer(3));  // throws Exception
        System.out.println(queue2.offer(3));  // false



    }
}
