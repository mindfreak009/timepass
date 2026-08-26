package dsa.binarysearch.binarysearchonanswer;

// Difficulty: Medium

// Given an array stalls[] representing the positions of stalls and an integer k denoting the number of aggressive cows,
// place the cows in the stalls such that the minimum distance between any two cows is as large as possible.
// Return this maximum possible minimum distance.

// Examples:
// Input: stalls[] = [1, 2, 4, 8, 9], k = 3
// Output: 3
// Explanation: We can place cow 1 at position 1, cow 2 at position 4 and cow 3 at position 9. So, the maximum possible minimum distance
// between two cows is 3.

// Input: stalls[] = [6, 7,  9, 11, 13, 15], k = 4
// Output: 2
// Explanation: We can place cow 1 at position 6, cow 2 at position 9, cow 3 at position 11 and cow 4 at position 15.
// So, the maximum possible minimum distance between two cows is 2.

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        // int[] stalls = {1, 2, 4, 8, 9};
        // int k = 3;
        int[] stalls = {6, 7,  9, 11, 13, 15};
        int k = 4;
        System.out.println(aggressiveCows(stalls, k));
    }

    private static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int start = Integer.MAX_VALUE;
        int end = 0;
        int n = stalls.length;
        for (int i = 0; i < n-1; i++) {
            start = Math.min(start, stalls[i+1] -stalls[i]);
        }
        end = stalls[n-1] -stalls[0];
        int ans = -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (isAllocationPossible(stalls, mid, k)) {
                ans = mid;
                start = mid +1;
            } else {
                end = mid -1;
            }
        }
        return ans;
    }

    private static boolean isAllocationPossible(int[] stalls, int minDistance, int cows) {
        int n = stalls.length;
        int count = 1;
        int lp = stalls[0];
        for (int i = 1; i < n; i++) {
            if(stalls[i] - lp >= minDistance){
                count++;
                lp = stalls[i];
            }
            if(count >= cows) {
                return true;
            }
        }
        return false;
    }
}
