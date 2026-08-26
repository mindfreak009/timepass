package dsa.sorting.cyclicsort;

// Difficulty: Easy

// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

// Example 1:
// Input: nums = [3,0,1]
// Output: 2
// Explanation:
// n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it
// does not appear in nums.

// Example 2:
// Input: nums = [0,1]
// Output: 2
// Explanation:
// n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not
// appear in nums.

// Example 3:
// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8
// Explanation:
// n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not
// appear in nums.

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};    // Output: 8
        // int[] arr = {0,1};
        System.out.println(missingNumber(arr));
    }

    private static int missingNumber(int[] arr) {
        int i = 0;
        int n = arr.length;
        while(i<n) {
            int expectedIndex = arr[i];
            if(expectedIndex >=n || arr[expectedIndex] == arr[i]){
                i++;
            } else {
                swapNums(arr, expectedIndex, i);
            }
        }
        for (int j = 0; j < n; j++) {
            if(arr[j] != j) return j;
        }
        return n;
    }

    private static void swapNums(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
