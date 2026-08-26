package dsa.binarysearch;

// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

//  Input: nums = [], target = 0
//  Output: [-1,-1]

import java.lang.reflect.Array;
import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int arr[] = {5,7,7,8,8,10};
        System.out.println("Reached here ::: ");
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        // check for first occurence if target is first
        ans[0] = search(nums, target, true);
        if(ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        System.out.println("ans in searchRange ::: " + Arrays.toString(ans));
        return ans;
    }

    // this function just returns the index value of target
    static int search(int[] nums, int target, boolean findStartIndex)  {
        int ans = -1;
        int start = 0;
        int end = nums.length -1;
        int mid = start + (end - start)/2;

        while (start <= end) {
            if(target < nums[mid]) {
                end = mid - 1;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                // potential answer found
                ans = mid;
                if(findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        System.out.println("ans :::" +ans);
        return ans;
    }




}
