package leetcode;

// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//   0 <= a, b, c, d < n
//   a, b, c, and d are distinct.
//   nums[a] + nums[b] + nums[c] + nums[d] == target
//   You may return the answer in any order.

// Example 1:
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

// Example 2:
// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]

// Constraints:
//     1 <= nums.length <= 200
//    -10^9 <= nums[i] <= 10^9
//    -10^9 <= target <= 10^9


import java.util.*;

public class FourSum {
    public static void main(String[] args) {

       // int[] input = {1,0,-1,0,-2,2};
       // int target = 0;

       // int[] input = {2,2,2,2,2};
       // int target = 8;
       // int[] input = {1000000000,1000000000,1000000000,1000000000};
       // int target = -294967296;
        int[] input = {1,0,-1,0,-2,2};
        int target = 0;

       // System.out.println(fourSum(input, target));
        System.out.println(fourSumImproved(input, target));
    }

    public static List<List<Integer>> fourSumImproved(int[] nums, int target) {

        // sort the elements
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int left = j+1;
                int right = nums.length-1;
                int target2 = nums[i] + nums[j];

                while(left < right) {
                    long sum = (long)nums[left] + nums[right] + target2;
                    if(sum == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum < target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> finallist = new ArrayList<>();
        Set<List<Integer>> unique = new HashSet<>();

        // sorting the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
           // if(i >0 && nums[i] == nums[i-1]) continue;  // Skip duplicates for i

            for (int j = i+1; j < nums.length ; j++) {
              //  if(j > 0 && nums[j] == nums[j-1]) continue;  // Skip duplicates for j

                int k = j+1;
                int l = nums.length - 1;
                while(k < l) {

                    // Typecasted to (long) since the program was failing for the below inputs :

                    // int[] nums = [1000000000,1000000000,1000000000,1000000000]
                    // target = -294967296

                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum < target) {
                        k++;
                    } else if(sum > target) {
                        l--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);

                        unique.add(list);
                        k++;
                        l--;
                    }
                }
            }

        }
        finallist.addAll(unique);

        return finallist;

    }
}
