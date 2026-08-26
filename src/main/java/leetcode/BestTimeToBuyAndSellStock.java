package leetcode;

// Medium level problem
// You want to maximize your profit by choosing a single day to buy one stock
// and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

// Time Complexity: 0(N)
// Space Complexity: O(1)

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

        // int[] prices = {7, 1, 5, 3, 6, 4};
        // int[] num = {7, 6, 4, 3, 1};
       // int[] prices = {1, 3, 4, 6, 7};
        int[] prices = {3, 2, 6, 5, 0, 3};;

        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            // System.out.println("maxCur :: " +maxCur);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }

        System.out.println("maxProfit :: " +maxSoFar);

    }


}

