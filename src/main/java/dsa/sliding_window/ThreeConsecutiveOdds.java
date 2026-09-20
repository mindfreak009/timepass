package dsa.sliding_window;

// LeetCode Ques: 1550
// Difficulty: Easy

// Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.

// Example 1:
// Input: arr = [2,6,4,1]
// Output: false
// Explanation: There are no three consecutive odds.

// Example 2:
// Input: arr = [1,2,34,3,4,5,7,23,12]
// Output: true
// Explanation: [5,7,23] are three consecutive odds.

// Constraints:
//   ●  1 <= arr.length <= 1000
//   ●  1 <= arr[i] <= 1000

public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int[] arr = {1,2,34,3,4,5,7,23,12};
        System.out.println(threeConsecutiveOdds(arr));
        System.out.println(threeConsecutiveOdds1(arr));
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        int count = 0;

        for(int i=0; i<len; i++) {
            if(arr[i] % 2 != 0) {
                count++;
            } else {
                count=0;
            }
            if(count == 3) {
                return true;
            }
        }
        return false;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static boolean threeConsecutiveOdds1(int[] arr) {
        int len = arr.length;
        int count = 0;
        int windowSize = 3;

        // initial window
        for(int i=0; i<3; i++) {
            if(arr[i] % 2 != 0) {
                count++;
            }
            if(count == 3) {
                return true;
            }
        }

        // remaining window
        for(int i=1; i<len-3; i++) {
            // element that is getting removed from the sliding window, i.e, previous number)
            if(arr[i-1]%2 != 0) {
                count--;
            }
            // element that is getting added in the sliding window
            if(arr[i+windowSize-1] % 2 != 0) {
                count++;
            }

            if(count == 3) {
                return true;
            }
        }
        return false;
    }
}
