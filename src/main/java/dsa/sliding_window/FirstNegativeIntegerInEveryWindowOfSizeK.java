package dsa.sliding_window;


// Brute Force Approach:
// Time Complexity:  (N-K)*K
// Space Complexity: o(1), since we are not using any extra space

// for (i -> 0 to N-K) {
//    for(j -> 0 to K) {
//        int elem = i+j;
//            if(el < 0) { res[i] = elem; }


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Space Complexity: [N-K+1] + O(K)
// Time Complexity: O(N)
public class FirstNegativeIntegerInEveryWindowOfSizeK {
    public static void main(String[] args) {
        long[] arr = {-8,2,3,-6,10};
        int k = 2;
        int n = arr.length;

        System.out.println(Arrays.toString(printFirstNegativeInteger(arr, k, n)));
    }

    public static long[] printFirstNegativeInteger(long[] arr, int k, int n) {
        Queue<Long> queue = new LinkedList<>();
        int index = 0;

        // For calculating first window:
        while(index < k) {
            if(arr[index] < 0) {
                queue.offer(arr[index]);
            }
            index++;
        }

        long res[] = new long[n-k+1];
        res[0] = (queue.isEmpty())?0: queue.peek();

        // For Calculating other windows:
        for(int i=1; i < n-k+1; i++){
            // remove previous number
            if(arr[i-1] < 0){
                queue.poll();
            }
            // add next number
            if(arr[i+k-1] < 0){
                queue.offer(arr[i+k-1]);
            }
            res[i] = (queue.isEmpty())?0: queue.peek();
        }
       return res;
    }

    public static long[] printFirstNegativeNumber1(long[] arr, int k, int n) {
        long res[] = new long[n-k+1];

        for (int i = 1; i < n-k+1; i++) {

        }

        return res;
    }
}
