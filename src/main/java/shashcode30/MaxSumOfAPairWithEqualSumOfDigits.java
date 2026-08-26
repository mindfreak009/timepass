package shashcode30;

// Leetcode: 2342
// Difficulty: Medium

// You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j,
// and the sum of digits of the number nums[i] is equal to that of nums[j].
// Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

// Example 1:
// Input: nums = [18,43,36,13,7]
// Output: 54
// Explanation: The pairs (i, j) that satisfy the conditions are:
//    - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
//    - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
// So the maximum sum that we can obtain is 54.

// Example 2:
// Input: nums = [10,12,19,14]
// Output: -1
// Explanation: There are no two numbers that satisfy the conditions, so we return -1.

// Constraints:
//      1 <= nums.length <= 10^5
//      1 <= nums[i] <= 10^9


import java.util.HashMap;
import java.util.Map;

public class MaxSumOfAPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        int[] nums ={18,43,36,13,7};    // Output: 54
        System.out.println(maximumSum(nums));
        System.out.println(maximumSumImproved(nums));
    }

    // Time Complexity: O(n)
    public static int maximumSum(int[] nums) {
       //Timer: start time
       final long startTime = System.nanoTime();

       Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        System.out.println(System.currentTimeMillis());
        for(int num: nums) {
            int digitSum = getDigitSum(num);
            if(map.containsKey(digitSum)) {
                int prevNum = map.get(digitSum);
                ans = Math.max(prevNum + num, ans);
                map.put(digitSum, Math.max(prevNum, num));
            } else {
                map.put(digitSum, num);
            }
        }

        //Timer: end time
        final long duration = System.nanoTime() - startTime;
        System.out.println("Final time taken--> HashMap:: " + duration);
        return ans;
    }

    // Time Complexity: O(log n)
    private static int getDigitSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum += (num % 10);;
            num = num / 10;
        }
        return sum;
    }

    // Time Complexity: O(n)
    public static int maximumSumImproved(int[] nums) {

        // Here we have taken 82 because 10^9 would become 1000000000, and doing (-1) to it will result in 999999999
        // If we add the digits sum, it would result in 81.
        // Here we took 82, to accommodate an index value to it. because 81 + 1 = 82
        int[] map = new int[82];
        int ans = -1;

        //Timer: start time
        final long startTime = System.nanoTime();

        for(int num: nums) {
            int digitSum = getDigitSum(num);
            if(map[digitSum] > 0) {
                int prevNum = map[digitSum];
                ans = Math.max(prevNum + num, ans);
                map[digitSum] =  Math.max(prevNum, num);
            } else {
                map[digitSum] = num;
            }
        }

        //Timer: end time
        final long duration = System.nanoTime() - startTime;
        System.out.println("Final time taken--> arrays:: " + duration);
        return ans;
    }
}
