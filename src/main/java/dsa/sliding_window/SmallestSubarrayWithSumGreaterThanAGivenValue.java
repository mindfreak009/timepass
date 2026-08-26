package dsa.sliding_window;

// Input: x = 100, arr[] = [1, 10, 5, 2, 7]
// Output: 0
// Explanation: No subarray exist

// Output: Minimum length subarray is [4, 45, 6]
public class SmallestSubarrayWithSumGreaterThanAGivenValue {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        int val = 51;
        System.out.println(smallestSubarrayWithSumGreaterThanAGivenValue(arr, val));
    }

    private static int smallestSubarrayWithSumGreaterThanAGivenValue(int[] arr, int target) {
        int windowStart = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            // 1. Expanding the window
            sum+= arr[windowEnd];
            while(sum > target) {
                minLength = Math.min(minLength, windowEnd-windowStart+1); // we are adding +1, since the array index begins with 0 index...
                // 2. Shrinking the window
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength;
    }
}
