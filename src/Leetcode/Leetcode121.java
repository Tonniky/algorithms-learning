package Leetcode;

public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int score = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; i++) {
                int temp = prices[i] - prices[j];
                if(temp > score) {
                    score = temp;
                }
            }
        }
        return score;
    }
    }
