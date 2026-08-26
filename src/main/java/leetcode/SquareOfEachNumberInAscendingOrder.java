package leetcode;

// Given an integer arrays nums, already sorted in non-decreasing order
// return an array of the squares of each number sorted in non-decreasing order

// int nums[] = { -4, -1, 0, 3, 10};
// Output :: [0, 1, 9, 16, 100]

// Time complexity : 0(N)
// Space complexity = 0(N)
import java.util.Arrays;

public class SquareOfEachNumberInAscendingOrder {
    public static void main(String[] args) {

        // int[] nums = {-4,-1, 0, 3, 10};
        int[] nums = {-11,-12,0,3,10};
        System.out.println(Arrays.toString(squareOfEachNumber(nums)));
    }

    private static int[] squareOfEachNumber(int[] nums) {
        int[] result = new int[nums.length];

        int start = 0;
        int end = nums.length -1;

        for (int i = end; i >= 0; i--) {
                if(Math.abs(nums[start]) > Math.abs(nums[end])) {
                    result[i] = nums[start] * nums[start];
                    start++;
                } else {
                    result[i] = nums[end] * nums[end];
                    end--;
                }
        }
        return result;
    }
}
