package leetcode;

// HARD level problem
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete at most two transactions.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.

// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Time Complexity: 0(N)
// Space Complexity: O(1)
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {

        // int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
       // int[] prices = {1,2,3,4,5};
       // int[] prices = {10, 22, 5, 75, 65, 80};  // profit: 87. {{22-10=12, 12+(80-5)}}
         int[] prices = {100, 30, 15, 10, 8, 25, 80}; // profit: 72. {{80-8=72}}
        System.out.println(maxProfit(prices));
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) // Stream of List<Integer>
                .flatMap(List::stream)
                .map(integer -> integer + 1)
                .collect(Collectors.toList());

        System.out.println("together :: " +together);
    }

    private static int maxProfit(int[] prices) {

        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;

        for(int i=0; i<prices.length; i++){
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i]-buy1);

            // I already made sell1 dollars from my first transaction, so when I buy my second stock, my effective cost is (price - sell1)
            buy2 = Math.min(buy2, prices[i]-sell1);  // uses profit from #SELL1
            sell2 = Math.max(sell2, prices[i]-buy2);
        }
        return sell2;
    }
}
