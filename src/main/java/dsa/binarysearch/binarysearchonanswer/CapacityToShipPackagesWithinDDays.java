package dsa.binarysearch.binarysearchonanswer;

// Difficulty: Medium

// A conveyor belt has packages that must be shipped from one port to another within days.

// The i^th package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on
// the conveyor belt (in the order given by weights).
// We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days.

// Example 1:
// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
// Output: 15
// Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10

// Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into
// parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

// Example 2:
// Input: weights = [3,2,2,4,1,4], days = 3
// Output: 6
// Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
// 1st day: 3, 2
// 2nd day: 2, 4
// 3rd day: 1, 4

// Example 3:
// Input: weights = [1,2,3,1,1], days = 4
// Output: 3
// Explanation:
// 1st day: 1
// 2nd day: 2
// 3rd day: 3
// 4th day: 1, 1

// Constraints:
// 1 <= days <= weights.length <= 5 * 10^4
// 1 <= weights[i] <= 500

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;
        System.out.println(shipWithinDays(weights,days));
    }

    // Time Complexity: O(N*logK + N)
    public static int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE;
        int end = 0;

        // Calculating search spaces
        for (int w: weights) {
            start = Math.max(start, w);
            end = end + w;
        }
        int ans = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(isShipmentPossible(weights, mid, days)) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }

    private static boolean isShipmentPossible(int[] weights, int capacity, int days) {
        int d = 1;
        int count = 0;

        for (int w: weights) {
            count+= w;
            if(count > capacity) {
                d++;
                count = w;
            }
            if(d > days) {
                return false;
            }
        }
        return true;
    }
}
