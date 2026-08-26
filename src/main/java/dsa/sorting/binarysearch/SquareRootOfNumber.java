package dsa.sorting.binarysearch;

public class SquareRootOfNumber {
    public static void main(String[] args) {
        int n = 100;
        System.out.println("squareRoot of number 100 is :: " +binarySearch(n));
        System.out.println(squareRoot(n));
    }

    static int binarySearch(int num){
        int start = 1;
        int end = num;
        int mid = start + (end - start)/2;
        int ans = -1;

        while(start <= end){
            int square = num * num;
            if(square == num) {
                return mid;
            }

            if(square < num) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start)/2;
        }
        return ans;
    }

    // Function to find cuberoot
    static int squareRoot(int number) {
        // Lower bound
        int left = 1;

        // Upper bound
        int right = number;

        int ans = 0;
        while (left <= right) {
            // Finding the mid value
            int mid = left + (right - left) / 2;

            // Checking the mid value
            if (mid * mid == number) {
                return mid;
            }
            // Shift the lower bound
            if (mid * mid < number) {
                left = mid + 1;
                ans = mid;
            }
            // Shift the upper bound
            else {
                right = mid - 1;
            }
        }

        // Return the ans
        return ans;
    }
}
