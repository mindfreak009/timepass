package leetcode;
// LeetCode Ques: 121
// Difficulty level: Easy

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
        // int[] prices = {7, 1, 5, 3, 6, 4};  // Output: 5
        // int[] num = {7, 6, 4, 3, 1};        // Output: 0
       // int[] prices = {1, 3, 4, 6, 7};        // Output: 0
       int[] prices = {3, 2, 6, 5, 0, 3};     // Output: 4
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }


}

