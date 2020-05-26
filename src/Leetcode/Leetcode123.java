package Leetcode;

public class Leetcode123 {

    public int maxProfit(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxProfit1 = 0;
        int maxProfitAfterBuy = Integer.MIN_VALUE;
        int maxProfit2 = 0;
        for (int i = 0 ; i < prices.length; i++) {
            minPrices = Math.min(minPrices, prices[i]);
            maxProfit1 = Math.max(maxProfit1, prices[i] - minPrices);
            maxProfitAfterBuy = Math.max(maxProfitAfterBuy, maxProfit1 - prices[i]);
            maxProfit2 = Math.max(maxProfit2, maxProfitAfterBuy + prices[i]);
        }
        return maxProfit2;
    }
}