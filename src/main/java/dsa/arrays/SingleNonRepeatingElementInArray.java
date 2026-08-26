package dsa.arrays;

import java.util.HashMap;
import java.util.Map;

// Difficulty: Easy

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

// Example 2:
// Input: nums = [4,1,2,1,2]
// Output: 4

// Example 3:
// Input: nums = [1]
// Output: 1

// Constraints:
// 1 <= nums.length <= 3 * 104
// -3 * 10^4 <= nums[i] <= 3 * 10^4
// Each element in the array appears twice except for one element which appears only once.

public class SingleNonRepeatingElementInArray {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        // int[] arr = {2,2,1};
        System.out.println(singleNumberUsingXOR(arr));
        System.out.println(singleNumber(arr));
    }

    // using XOR
     public static int singleNumberUsingXOR(int[] arr) {
        // variable to store the result of XOR of arr
        int sing = arr[0];

        for(int i=1; i<arr.length; i++) {
            // XOR the elements with previous result
            sing = sing ^ arr[i];
        }
        // return the result
        return sing;
    }

    // using HashMap
    public static int singleNumber(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Integer number = 0;
        for(int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        return  freqMap.entrySet()
                .stream()
                .filter(v -> v.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);


    }
}
