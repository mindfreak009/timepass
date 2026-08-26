package dsa.queue.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SecondLargestElementInArray {

    public static void main(String[] args) {
            int[] arr = {12,13,34,6,50,7,52, 52};
            // int[] arr = {12,12,12,12,12,12,12};

            System.out.println("Second Largest Elem: " +secondLargestElement(arr));
            System.out.println("Second Largest Elem (PQ): " +secondLargestElement_using_PriorityQueue(arr));
        }

        // Time Complexity: O(N)
        private static int secondLargestElement(int[] arr) {
            int max = Integer.MIN_VALUE;
            int secondMax = 0;
            // Arrays.sort(arr);  // o(nlogN) + O(N)

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > max && secondMax != max) {
                    secondMax = max;
                    max = arr[i];
                }
            }

            if(secondMax < 0) {
                return 0;
            }
            return secondMax;

        }

    private static int secondLargestElement_using_PriorityQueue(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.offer(num);  // Add the current element to the priority queue
            if (pq.size() > 2) {
                pq.poll();  // Remove the smallest element if there are more than 2 elements
            }
        }

        System.out.println("pq poll :: " +pq.poll());
        // After processing all elements, the second largest element will be the root of the priority queue
        return pq.peek();
        
    }
}
