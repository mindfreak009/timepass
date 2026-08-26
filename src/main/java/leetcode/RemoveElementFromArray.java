package leetcode;

// Difficulty level - EASY

import java.util.Arrays;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        int val = 2;
        System.out.println(removeElement(arr, val));
    }
    public static int removeElement(int[] nums, int val) {
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == val) {
                count++;
            }
        }

        int[] newArray = new int[nums.length - count];
        int newIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                newArray[newIndex] = nums[i];
                newIndex++;
            }
        }
        System.out.println(Arrays.toString(newArray));
        return count;
    }
}
