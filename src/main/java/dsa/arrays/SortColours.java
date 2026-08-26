package dsa.arrays;
import java.util.Arrays;

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
// with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// Could you come up with a one-pass algorithm using only constant extra space?

// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// Example 2:
// Input: nums = [2,0,1]
// Output: [0,1,2]


// Similar questions -> arrays-> MoveZeroes

public class SortColours {
    public static void main(String[] args) {

       // int[] nums = {2,0,2,1,1,0};
        int[] nums = {2,0,1};
        int[] result = sortColours(nums);
        System.out.println(Arrays.toString(result));
    }

    // solved using 3 pointer approach
    private static int[] sortColours(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int index = 0;

        while(index<=end) {
            if(nums[index] == 0) {
                swap(nums, index, start);
                index++;
                start++;
            } else if(nums[index] == 2){
                swap(nums, index, end);
                end--;
            } else {
                index++;
            }
        }

        return nums;
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
