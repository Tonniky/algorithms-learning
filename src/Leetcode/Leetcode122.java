package Leetcode;

public class Leetcode122 {
    public int maxProfit(int[] prices) {
        return cal(prices, 0);
    }

    public int cal(int[] price, int n) {
        if(n >= price.length) {
            return 0;
        }
        int max = 0;
        for (int start = n; start < price.length; start++) {
            int maxProfit = 0;
            for (int j = n + 1; j < price.length; j++) {
                if (price[start] < price[j]) {
                    int profit = cal(price, start + 1) + price[j] - price[start];
                    if(profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
            if (maxProfit > max)
                max = maxProfit;
        }
        return max;
    }



    public int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length==0||prices==null)
            return 0;
        int minPrices=prices[0];
        int sumPrices=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=minPrices){
                sumPrices+=prices[i]-minPrices;
                minPrices=prices[i];
            }else{
                minPrices=prices[i];
            }
        }
        return sumPrices;
    }
    }
