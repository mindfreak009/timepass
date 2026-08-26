package dsa.sliding_window;

import java.util.Arrays;

// Number of array size denoted by(N) - 8
// Number of children denoted by (M) - 5
// int[] arr = {3,4,1,9,56,7,9,12};
// Output: 6

// Time Complexity: O(NlogN) + (n-m) = O(NlogN) (because we are considering the highest value)
// Space Complexity: O(1)
public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr = {4,1,9,3,56,7,9,12};
        int n  = arr.length;
        int m = 5;
        System.out.println("Minimum Difference is :: " + findMinimumDiff(arr, n, m));
    }

    private static int findMinimumDiff(int[] arr, int n, int m) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

       // for (int i = 0; i+m-1 < n; i++) { // Corrected loop condition
        for (int i = 0; i< n-m+1; i++) { // Corrected loop condition
           int diff = arr[i+m-1] - arr[i];
           if(diff < minDiff) {
               minDiff = diff;
           }
        }
        return minDiff;
    }
}

//  minDiff = Math.min(arr[(int) (i+m-1)] - arr[i], minDiff);
