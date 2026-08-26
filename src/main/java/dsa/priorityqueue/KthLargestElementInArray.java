package dsa.priorityqueue;

// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Can you solve it without sorting?

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4

//Constraints:
// 1 <= k <= nums.length <= 105
//-104 <= nums[i] <= 104

import java.util.Arrays;
import java.util.PriorityQueue;

// Leetcode - Medium
public class KthLargestElementInArray {
    public static void main(String[] args) {
        // int[] arr = {6,2,3,4,1,9};
        //  int k = 3;
         int[] arr = {3,2,1,5,6,4};
         int k = 2;
//        int[] arr = {3,2,3,1,2,4,5,5,6};
//        int k = 4;

       // System.out.println("ans :: " + kthLargestElementInArray(arr, k));
       // System.out.println("ans2 :: " + withArraysSortMethod(arr, k));
        System.out.println("ans3 :: " + KthLargestElementInArray(arr, k));
    }

    // Time Complexity : O(N)
    private static int kthLargestElementInArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            pq.add(j);
        }

        System.out.println("priority queue :: " +pq);
        for (int i = k; i < arr.length; i++) {
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    // O(N log N)
    private static int withArraysSortMethod(int[] arr, int k) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return arr[arr.length-k];
    }

    // O(N)
    private static int KthLargestElementInArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            pq.add(j);
        }

        System.out.println("pq :: " +pq);
        for (int i = 0; i < arr.length-k; i++) {
            pq.remove();
        }

        System.out.println("pq now :: " +pq);
        return pq.poll();
    }
}
