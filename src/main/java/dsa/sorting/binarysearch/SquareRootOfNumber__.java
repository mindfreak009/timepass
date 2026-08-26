package dsa.sorting.binarysearch;

// Time Complexity : O(N)
// Space complexity : O(1)

public class SquareRootOfNumber__ {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(squareRoot(n));
    }

    // Function to find squareRoot of a number
    static int squareRoot(int number) {
        // Lower bound
        int low = 1;

        // Upper bound
        int high = number;

        // Store the answer
        int ans = 0;

        while (low <= high) {
            // Finding the mid value
            int mid = low + (high - low) / 2;

            // Checking the mid value
            if (mid * mid == number) {
                return mid;
            } else if (mid * mid <= number) {
                // Shift the lower bound
                low = mid + 1;
                ans = mid;
            }
            // Shift the upper bound
            else {
                high = mid - 1;
            }
        }

        // Return the ans
        return ans;
    }
}
