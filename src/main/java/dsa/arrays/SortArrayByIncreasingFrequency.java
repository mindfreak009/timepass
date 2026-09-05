package dsa.arrays;

// Leetcode Ques:
// Difficuty: Medium

// Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
// If multiple values have the same frequency, sort them in decreasing order.
// Return the sorted array.

// Example 1:
// Input: nums = [1,1,2,2,2,3]
// Output: [3,1,1,2,2,2]
// Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

// Example 2:
// Input: nums = [2,3,1,3,2]
// Output: [1,3,3,2,2]
// Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

// Example 3:
// Input: nums = [-1,1,-6,4,5,-6,1,4,1]
// Output: [5,-1,4,4,-6,-6,1,1,1]

// Constraints:
//    • 1 <= nums.length <= 100
//    • -100 <= nums[i] <= 100

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};   // Output:  [5,-1,4,4,-6,-6,1,1,1]

        System.out.println(Arrays.toString(frequencySort(nums)));
        System.out.println(Arrays.toString(frequencySortUsingPriorityQueue(nums)));
    }

    // Time Complexity: O(N) + O(N logN)
    public static int[] frequencySort(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        Integer temp[] = new Integer[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            temp[i] = nums[i];
        }

        // Since Java does not allow custom comparators with primitive int[] arrays, we convert the array to Integer[],
        // which supports comparator-based sorting.
        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // If multiple values have the same frequency, sort them in decreasing order.
                if(freq.get(a) == freq.get(b)) {
                    return b - a;
                }
                // increasing order of frequency
                return freq.get(a) - freq.get(b);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
        return nums;
    }

    // Time Complexity: O(N) + O(N logN)
    public static int[] frequencySortUsingPriorityQueue(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // If multiple values have the same frequency, sort them in decreasing order.
                if(freq.get(a) == freq.get(b)) {
                    return b - a;
                }
                // increasing order of frequency
                return freq.get(a) - freq.get(b);
            }
        });

        for(Integer key: freq.keySet()) {
            pq.offer(key);
        }

        int i=0;
        while(!pq.isEmpty()) {
            int key = pq.poll();
            int f = freq.get(key);
            for (int j = 0; j < f; j++) {
                nums[i] = key;
                i++;
            }
        }

        return nums;
    }


}



//    public static int[] frequencySortImproved(int[] nums) {
//
//        Map<Integer, Integer> freq = new HashMap<>();
//        for (int num: nums) {
//            freq.put(num, freq.getOrDefault(num, 0)+1);
//        }
//
//        Integer temp[] = new Integer[freq.size()];
//        int i=0;
//        for (Integer key : freq.keySet()) {
//             temp[i] = key;
//             i++;
//        }
//
//        Arrays.sort(temp, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                // If multiple values have the same frequency, sort them in decreasing order.
//                if(freq.get(a) == freq.get(b)) {
//                    return b - a;
//                }
//                // increasing order of frequency
//                return freq.get(a) - freq.get(b);
//            }
//        });
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = temp[i];
//        }
//        return nums;
//    }
