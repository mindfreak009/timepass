package dsa.greedy_algorithm;

import java.util.Arrays;

// Output: 3
// Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)
public class MinimumPlatformsProblem {

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

       // int n = 6;
        System.out.println("final answer :: " + findPlatform(arr, dep, arr.length));
        System.out.println("findMinimumPlatorms :: " +findMinimumPlatforms(arr,dep));
    }
    // Returns minimum number of platforms required
    // Time Complexity: O(n * n), Two nested loops traverse the array.
    // Auxiliary space: O(1), As no extra space is required.
    public static int findPlatform(int arr[], int dep[], int n) {

        // plat_needed indicates number of platforms needed at a time
        int plat_needed = 1, result = 1;

        // run a nested  loop to find overlap
        for (int i = 0; i < n; i++) {
            // minimum platform
            plat_needed = 1;

            for (int j = 0; j < n; j++) {
                if (i != j)
                    // check for overlap
                    if (arr[i] >= arr[j] && dep[j] >= arr[i])
                        plat_needed++;
            }
            // update result
            result = Math.max(result, plat_needed);
        }
        return result;
    }


    // Function to find the minimum number of platforms required in a railway station such that no train awaits.
    // Time complexity : O(n logn)
    private static int findMinimumPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count = 0;
        int ans = 0;

        int i=0, j=0;  // Two pointer approach

        while(i < arr.length && j < dep.length){
            if(arr[i] <= dep[j]) {
                count++;
                i++;
            } else  {            // if (arr[i] > dep[j]){   // removed this condition
                count--;    // train departed, decrease count
                j++;        // move to next departure time
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }

}
;