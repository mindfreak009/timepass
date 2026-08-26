package leetcode;

// Here, the maximum profit will be (6 - 2) + (3 - 0) = 7.
// Buy the stock on day 2(price = 2) and sell it on day 3(price = 6)
// Rebuy it on day 5(price = 0) and sell it on day 6(price = 3)

public class BuyAndSellStockWithMaxProfitAndKTransactions {
    public static void main(String[] args) {
        int[] prices  = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(getMaxProfitOnBuyAndSellStock(prices, k));
    }

    private static int getMaxProfitOnBuyAndSellStock(int[] prices, int k) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                maxProfit+= (prices[i] - prices[i-1]);
                k--;
            }
        }
        return maxProfit;
    }
}
