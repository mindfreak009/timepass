package dsa.sorting.binarysearch;

// Difficulty: Easy

// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
// Return the kth positive integer that is missing from this array.

// Example 1:
// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

// Example 2:
// Input: arr = [1,2,3,4], k = 2
// Output: 6
// Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

// Example 3:
// Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
// Output: 2
// Explanation: Missing are 1, 2, 4, 6, 7, 8, 13,...  and 2nd missing number is 2.

// Constraints:
// 1 <= arr.length <= 1000
// 1 <= arr[i] <= 1000
// 1 <= k <= 1000
// arr[i] < arr[j] for 1 <= i < j <= arr.length

// Follow up:
// Could you solve this problem in less than O(n) complexity?


public class FindKthMissingPositiveNumber {
    public static void main(String[] args) {
       // int[] arr = {1,2,3,4};
       // int k = 2;
        int[] arr = {2,3,4,7,11};  // missing numbers: 1,5,6,8,9,12
        int k = 5;
        // int[] arr = {3, 5, 9, 10, 11, 12};  // missing numbers: 1,2,4,6,7,8,13
        // int k = 2;
        System.out.println(findKthPositive(arr, k));
        System.out.println(findKthPositiveUsingLinearApproach(arr, k));
    }

    // Binary Search
    public static int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;

        // Start a loop and keep moving till left is less than right
        while(left < right) {
            // Calculate the mid
            int mid = left + (right -left)/2;

            // If the number of missing elements is less than K
            // missing = value - position-1
            // "Have we found fewer missing numbers than we want?"
            if(arr[mid] - mid-1 < k){
               // Move left to mid + 1
                left = mid + 1;
            } else {
                // Move right to mid
                right = mid;
            }
        }
        return left + k;
    }

    // Linear Approach
    public static int findKthPositiveUsingLinearApproach(int[] arr, int k) {
        // Using linear approach
        for(int i = 0; i < arr.length; i++) {
            int missing = arr[i] - (i + 1);
            if(missing >= k)
                return k + i;
        }
        return k + arr.length;
    }


}
