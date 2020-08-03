package Leetcode;

public class findPoisonedDuration495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length ==0) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }
        int sum = 0;
        int len = timeSeries.length;
        sum = timeSeries[len - 1] - timeSeries[0] + duration;
        for (int i = 1; i < len; i++) {
            if (timeSeries[i] - timeSeries[i - 1] > duration) {
                sum -= (timeSeries[i] - timeSeries[i - 1] - duration);
            }
        }
        return sum;
    }
    }
