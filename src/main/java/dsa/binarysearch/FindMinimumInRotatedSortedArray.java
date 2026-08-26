package dsa.binarysearch;

// Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
// For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.

// Given the sorted rotated array nums of unique elements, return the minimum element of this array.
// Example 1:
// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

// Example 2:
// Input: nums = [4,5,6,7,0,1,2]
// Output: 0
// Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

// Example 3:
// Input: nums = [11,13,15,17]
// Output: 11
// Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int minIndex = findMin(nums);
        System.out.println("The minimum in rotated sorted array is : " + nums[minIndex]);
    }

    private static int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end-start)/2;
            if(mid > 0 && arr[mid] < arr[mid-1]) {
                return mid;
            }
            // if right half is sorted, move left
            else if(arr[end] > arr[mid]) {
                end = mid - 1;
            }
            // if left half is sorted, move right
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}
