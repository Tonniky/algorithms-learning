package Leetcode;

public class numWaterBottles1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        return  numSum(numExchange, numBottles, numBottles);
    }

    public int numSum(int numB, int num, int sum) {
        while(numB <= num) {
            sum = sum + num / numB;
            num = num / numB + num % numB;
        }
        return sum;
    }
}
