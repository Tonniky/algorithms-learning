package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode59 {

    public int[][] generateMatrix(int n) {
        int tR = 0;
        int tC = 0;
        if(n == 0) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        int dR = n - 1;
        int dC = n - 1;
        int num = 1;
        List<Integer> result = new ArrayList<>();
        while(tR <= dR && tC <= dC) {
            int temp = printEdge(res, tR++, tC++, dR--, dC--, num);
            num = temp;
        }
        return res;
    }

    public int printEdge(int[][] res, int tR, int tC, int dR, int dC, int num) {
        int curR = tR;
        int curC = tC;
        if (tR == dR) {
            res[tR][dR] = num;
        } else {
            while (curC < dC) {
                res[tR][curC] = num;
                num++;
                curC++;
            }
            while (curR < dR) {
                res[curR][dR] = num;
                num++;
                curR++;
            }
            while (curC > tC) {
                res[dR][curC] = num;
                num++;
                curC--;
            }
            while (curR > tR) {
                res[curR][tC] = num;
                num++;
                curR--;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Leetcode59 leet = new Leetcode59();
        leet.generateMatrix(3);
    }
}
