package leetcode;

// Medium level problem
// On each day, you may decide to buy/and or sell stock. You can only hold at most 1 share of stock at any time.
// However, you can buy it then immediately sell it on the same day.
// Find the maximum profit you can achieve.

// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
// Total profit is 4 + 3 = 7.

// Example 2:
// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Total profit is 4.

// Example 3:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: There is no way to make a positive profit, so we never buy the stock
// to achieve the maximum profit of 0.



// Time Complexity: 0(N)
// Space Complexity: O(1)

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {

      int[] num = {7,1,5,3,6,4};

      // int[] num = {7, 6, 4, 3, 1};
      // int[] num = {1, 3, 4, 6, 7};
        int profit = 0;
        int firstProfit = 0;
        for (int i = 0; i < num.length-1; i++) {

            int buyDate = num[i];
            int sellDate = num[i+1];

            if(buyDate < sellDate) {
                profit = profit + (sellDate - num[i]);
                firstProfit = profit;
                profit = Math.max(firstProfit, profit);
                System.out.println("profit :: " +profit);
            }
        }

        System.out.println("Profit is : " +profit);

    }
}
