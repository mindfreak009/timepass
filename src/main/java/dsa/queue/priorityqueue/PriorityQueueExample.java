package dsa.queue.priorityqueue;

import java.util.PriorityQueue;
// In Java, by default PriorityQueue is implemented using minHeap.
// To change the behavior to maxHeap, just put ::
//     new PriorityQueue<>(Comparator.reverseOrder());

// Formula to get the value of PriorityQueue
//  PARENT =  arr[i-1]/2
//  LEFT   =  arr[2*i + 1]
//  RIGHT  =  arr[2*i + 2]

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(2);

        System.out.println(priorityQueue);
        System.out.println("PriorityQueue size ::" +priorityQueue.size());
        while(!priorityQueue.isEmpty()) {
            System.out.println("peek ::" + priorityQueue.peek());
            priorityQueue.poll();

        }



    }
}
