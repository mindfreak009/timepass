package dsa.stacks;

// LeetCode Ques: 739
// Difficulty:  Medium

// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
// is the number of days you have to wait after the ith day to get a warmer temperature.

// If there is no future day for which this is possible, keep answer[i] == 0 instead.

// Example 1:
// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

// Example 2:
// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]

// Example 3:
// Input: temperatures = [30,60,90]
// Output: [1,1,0]

// Constraints:
//    ●  1 <= temperatures.length <= 10^5
//    ●  30 <= temperatures[i] <= 100

import java.util.Arrays;
import java.util.Stack;

// Output: [1,1,4,2,1,1,0,0]
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temp = new int[] {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        // edge case
        if(temperatures == null || temperatures.length <=1) {
            return new int[]{};
        }

        // res to hold the final answer
        int[] ans = new int[temperatures.length];

        // stack to hold the indices
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                 int prevIndex = stack.pop();
                 ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return ans;

    }
}
