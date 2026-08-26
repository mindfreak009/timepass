package dsa.sliding_window;

// Given an array of integers (arr[]), and a number X, find the smallest subarray with sum greater than given value.
// NOTE: The number always exist. It is guaranteed that X doesn't exceed te summation of arr[i] from (1 to N)

// arr[] = {1,4,45,6,0,19}
// X= 51
// Output = 2
// Explanation: Minimum length sub-array is {45,6}


public class SmallestSubarrayWithSumGreaterThanK {
    public static void main(String[] args) {
        int arr[] = {1,4,45,6,0,19};
        int X = 55;
        System.out.println(bruteForceApproach(arr, X));
        System.out.println(slidingWindow(arr, arr.length, X));
        //slidingWindow(arr, 6, X);
    }

    // Time Complexity: O(2N) and we remove the constant, it finally becomes O(N)
    private static int slidingWindow(int[] arr, int n, int x) {
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int len = 0;

        while(windowEnd < n){
            // expansion
            sum+= arr[windowEnd];
            if(sum > x) {
                len = windowEnd - windowStart + 1;
                minLen = Math.min(minLen, len);

                // shrinking
                while(windowStart > windowEnd && sum > x) {
                    sum+= arr[windowStart];
                    windowStart++;
                    if(sum > x){
                        len = windowEnd - windowStart + 1;
                        minLen = Math.min(minLen, len);
                    }
                }
            }
            windowEnd++;

        }

        return (minLen==Integer.MAX_VALUE)?0:minLen;
    }

    // Time Complexity : O(N^2)
    private static int bruteForceApproach(int[] arr, int x) {

        int currSum = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            // System.out.println("currSum ::: " +currSum);
            for (int j = i + 1; j < arr.length; j++) {
                if (currSum > x) {
                    result = j - i + 1;
                    // System.out.println("result ::: " +result);
                }
            }
        }
        return result;
    }
}
