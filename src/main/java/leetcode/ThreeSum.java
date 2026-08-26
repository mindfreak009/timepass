package leetcode;

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
// i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

//  Example 1:
//  Input: nums = [-1,0,1,2,-1,-4]
//  Output: [[-1,-1,2],[-1,0,1]]

// Explanation:
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

// Example 2:
// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.

// Example 3:
// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

import java.util.*;

// Time Complexity : O(N^2)
// Space Complexity: O(N)
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

      //  List<List<Integer>> finalResult = threeSum(arr);
//        for (List<Integer> f : finalResult) {
//            System.out.print(f + ",");
//        }
        System.out.println(threeSumImproved(arr));

    }

    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public static List<List<Integer>> threeSumImproved(int[] arr) {

        if(arr == null || arr.length < 3) return new ArrayList<>();

        // sort the elements
        Arrays.sort(arr);
        Set<List<Integer>> result = new HashSet<>();

        // Now fix the first element and find the other two elements
        for (int i = 0; i < arr.length-2; i++) {
            // Find other two elements using TwoSum approach
            int left = i+1;
            int right = arr.length-1;

            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0){
                    // Add to the set and move to find other triplets
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                } else if(sum < 0){
                    left++;
                } else {
                    right --;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listOfList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // Declaring 2 pointer variables
            int a,b;
            a = i+1;
            b = nums.length-1;

            while(a<b) {
                if(nums[i] + nums[a] + nums[b] == 0){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[a]);
                    tempList.add(nums[b]);

                    set.add(tempList);
                    // This value could be either a++ OR b--;
                    b--;
                } else if (nums[i] + nums[a] + nums[b] > 0) {
                    b--;
                } else {
                    a++;
                }
            }
        }
        for (List<Integer> t: set)  {
            listOfList.add(t);
        }
        return listOfList;
    }


}
