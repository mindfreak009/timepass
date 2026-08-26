package dsa.arrays;

// Difficulty: Easy

// Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.
// Note: The pairs must be returned in sorted order, the solution array should also be sorted, and the answer must not contain any duplicate pairs.
// Examples:
// Input: arr = [-1, 0, 1, 2, -1, -4]
// Output: [[-1, 1]]
// Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.

// arr[2] + arr[4] = 1 + (-1) = 0.
// The distinct pair are [-1,1].
// Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
// Output: [[-6, 6],[-1, 1]]
// Explanation: The distinct pairs are [-1, 1] and [-6, 6].

// Expected Time Complexity: O(n log n)
// Expected Auxiliary Space: O(n).

// Constraints:
// 3 <= arr.size <= 10^5
// -105 <= arr[i] <= 10^5

import java.util.HashMap;
import java.util.Map;

public class TwoSumPairsWith0Sum {
    public static void main(String[] args) {
         int[] arr = {-1, 0, 1, 2, -1, -4};
         int k = 3;
//        int[] arr = {1,5,7,1};
//        int k = 6;
        int n = arr.length;
        System.out.println(twoPairSumWith0Sum(arr, n, k));
    }

    public static int twoPairSumWith0Sum(int[] arr, int n, int k) {
        int res = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(arr[i] > k){
                continue;
            }
            int secondVal = k - arr[i];
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
            res+=  freqMap.getOrDefault(secondVal, 0);
        }

        return res;
    }
}
