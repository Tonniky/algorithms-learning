package Leetcode;

public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentStation = 0;
        int n = gas.length;
        int total = 0;
        int current = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];
            if (current < 0) {
                current = 0;
                currentStation = i + 1;
            }
        }
        return total >= 0 ? currentStation : -1;
    }
    }
