package dsa.binarysearch.binarysearchonanswer;

// Difficulty Level : Medium

// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
// The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas
// and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead
// and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4

// Example 2:
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30

// Example 3:
// Input: piles = [30,11,23,4,20], h = 6
// Output: 23

// Constraints:
//  1 <= piles.length <= 104
//  piles.length <= h <= 109
//  1 <= piles[i] <= 109

public class KokoEatingBananas {
    public static void main(String[] args) {
        // int[] piles = {3,6,7,11};
        // int h = 8;
        int[] piles = {30,11,23,4,20};
        int h = 6;

        System.out.println(minEatingSpeed(piles, h));
    }

    // Time Complexity: O(N*logm + n)
    public static  int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 1;

        // calculating search spaces
        for (int i = 0; i < piles.length ; i++) {
            end = Math.max(end, piles[i]);
        }
        int ans = 0;
        while(start <=end) {
            int mid = start + (end-start)/2;
            if(isPossible(piles, mid, h)) {
                // ans = Math.min(end, mid);
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] piles, int eatingSpeed, int hours) {
        long hCount = 0;
        for(int p : piles) {
            hCount+= p/eatingSpeed;
            // if(p%eatingSpeed > 0) hCount++;
            if(p%eatingSpeed !=0) {
                hCount++;
            }
        }
        //if(hCount<=hours) return true;
        if(hCount > hours) return false;

        // return false;
        return true;
    }
}
