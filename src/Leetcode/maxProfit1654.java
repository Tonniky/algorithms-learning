package Leetcode;

public class maxProfit1654 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int len = prices.length;
        int sum = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            sum = (sum + prices[i] - prices[i - 1]) < 0 ? 0 : sum + prices[i] - prices[i - 1];
            max = Math.max(max, sum);
        }
        return max;
    }
    }
