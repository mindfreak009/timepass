package dsa.sliding_window;

// Leetcode: HARD (239)

// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array
// to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.
// Example 1:
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]

// Explanation:
// Window position                 Max
// ---------------                -----
//   [1  3  -1] -3  5  3  6  7      3
//    1 [3  -1  -3] 5  3  6  7      3
//    1  3 [-1  -3  5] 3  6  7      5
//    1  3  -1 [-3  5  3] 6  7      5
//    1  3  -1  -3 [5  3  6] 7      6
//    1  3  -1  -3  5 [3  6  7]     7

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

// Constraints:
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
//  1 <= k <= nums.length

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};  // Output: {3,3,5,5,6,7}
        // int[] arr = {4, 3, 2, 0, 5, 9, 1, 0};  // Output: {4, 3, 5, 9, 9, 9}
        int k = 3;
        // System.out.println(Arrays.toString(slidingWindowMaximum(arr, k)));
        // System.out.println(Arrays.toString(bruteForce_slidingWindowMaximum(arr, k)));
        System.out.println(Arrays.toString(slidinggWindowMaximum(arr, k)));
    }


    // Time Complexity:
    // (number of windows) × (elements per window)
    //   = (n - k + 1) × k
    // In Big-O notation, we ignore lower-order terms and constants.
    // Time Complexity = O((n - k + 1) × k)
    // Or simply:  O(n × k)

    // Space Complexity: O(1)
    private static int[] bruteForce_slidingWindowMaximum(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        if (n == 0) { return res;}

        for (int i = 0; i < n-k+1; i++) {
            int ans = Integer.MIN_VALUE;
            int start = i;

            while(start<i+k) {
                ans = Math.max(ans, nums[start]);
                start++;
            }
            res[i] = ans;
        }
        return res;
    }

    // Time Complexity: O(M+N)
    // Space Complexity:
    private static int[] slidingWindowMaximum(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        if (n == 0) {
            return res;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        while (index < k) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[index]) {
                deque.pollLast();
            }
            deque.offerLast(index);
            index++;
        }
        res[0] = nums[deque.peekFirst()];

        for (int i = 1; i < n - k + 1; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= (i-1)) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i+k-1]) {
                deque.pollLast();
            }
            deque.offerLast(i+k-1);
            res[i] = nums[deque.peekFirst()];
        }
        return res;
    }

    private static int[] slidinggWindowMaximum(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        if (n == 0) {
            return res;
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if(deque.getFirst()+k == i) {
                deque.removeFirst();
            }
            if(i >= k-1) {
                res[j++] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
