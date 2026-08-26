package dsa.priorityqueue;

// Asked in NPCI

// Given an array of integers, perform exactly k operations.
// In each operation, choose an element, divide it by 2, and replace it with the ceiling of that value.
// The goal is to minimize the sum of the array after all k operations.

// Example 1:
// int[]  nums = [10, 20, 7]
// k = 4

// Explanation:
// Pick 7  → ceil(7/2)  = 4  → [10, 20, 4]
// Pick 10 → ceil(10/2) = 5  → [5, 20, 4]
// Pick 20 → ceil(20/2) = 10 → [5, 10, 4]
// Pick 10 → ceil(10/2) = 5  → [5, 5, 4]

// Example 2:
// int[] nums = [2, 3]
// k = 1

// Explanation:
// 2 → 1: [1, 3] → sum = 4
// 3 → 2: [2, 2] → sum = 4


import java.util.PriorityQueue;

public class MinimumSum {
    public static void main(String[] args) {
        int[] nums = {10, 20, 7};
        int k = 4;
        System.out.println(minSum(nums, k));
    }

    public static int minSum(int[] nums, int k) {
        // Both of the statments are true, because PriorityQueue by defaults uses min-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for(int num : nums) {
            maxHeap.offer(num);
            sum+= num;
        }

        System.out.println(maxHeap);
        System.out.println(sum);

        System.out.println("===================================");

        for(int i=0; i<k; i++) {
            int largest = maxHeap.poll();
            System.out.println("largest ::" +largest);

            // ceil (largest/2)
            int reduced = (largest+1)/2;
            System.out.println("===================================");

            // Take the old number out of the total.
            sum -= largest;
            // Put the new smaller number into the total.
            sum +=  reduced;

            maxHeap.offer(reduced);
            System.out.println("maxHeap:: " + maxHeap);
        }


        return sum;
    }


}
