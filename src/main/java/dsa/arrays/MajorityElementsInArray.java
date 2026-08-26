package dsa.arrays;

// Time Complexity: O(N)
// Space Complexity: O(1)

// Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.

import java.util.Arrays;


public class MajorityElementsInArray {
    public static void main(String[] args) {
        // int[] arr = {1,8,2,1,5,6,1,8,2,2,2};
       // int[] arr = {2,2,1,1,2,2,1};
        int[] arr = {3,1,3};
        // System.out.println(majorityElement(arr));
        System.out.println(majorityElementMooreAlgorithm(arr));
    }

    // Using sorting method
    // Time Complexity: O(n logn)
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int freq = 1;
        int ans = nums[0];

        for(int i= 1; i<n ; i++) {
            if(nums[i] == nums[i-1]) {
                freq++;
            } else {
                freq = 1;
                ans = nums[i];
            }

            if(freq > n/2) {
                return ans;
            }
        }
        return ans;
    }

    // Time Complexity: O(n)
    // Intitution :
    //   1. same element -> freq++,
    //   2. diff element -> freq--;
    public static int majorityElementMooreAlgorithm(int[] nums) {
        //  int[] arr = {2,2,1,1,2,2,1};
        int freq = 0, ans=0;
        for (int i = 0; i < nums.length; i++) {
            if(freq == 0) {
                ans = nums[i];
            }
            if(ans == nums[i]) {
                freq++;
            } else {
                freq--;
            }
        }

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if(ans == nums[i]) {
                counter++;
            } else {
                freq--;
            }
        }
        return counter > nums.length/3?ans:-1;
    }
}
