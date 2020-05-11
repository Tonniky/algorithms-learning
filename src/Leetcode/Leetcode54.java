package Leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
        public List<Integer> spiralOrder(int[][] matrix) {
            int tR = 0;
            int tC = 0;
            if(matrix.length == 0) {
                return new ArrayList<>();
            }
            int dR = matrix.length - 1;
            int dC = matrix[0].length - 1;
            List<Integer> result = new ArrayList<>();
            while(tR <= dR && tC <= dC) {
                List<Integer> res = printEdge(matrix, tR++, tC++, dR--, dC--);
                for(Integer tem : res) {
                    result.add(tem);
                }
            }
            return result;
        }

        public List<Integer> printEdge(int[][] m, int tR, int tC, int dR, int dC) {
            List<Integer> res = new ArrayList<>();
            if(tR == dR) {
                for(int i = tC; i <= dC; i++) {
                    res.add(m[tR][i]);
                }
                return res;
            } else if (tC == dC) {
                for(int i = tR; i <= dR; i++) {
                    res.add(m[i][tC]);
                }
                return res;
            } else {
                int curC = tC;
                int curR = tR;
                while(curC != dC) {
                    res.add(m[tR][curC]);
                    // System.out.print(m[tR][curC] + " ");
                    curC++;
                }
                while(curR != dR) {
                    res.add(m[curR][dC]);
                    // System.out.print(m[curR][dC] + " ");
                    curR++;
                }
                while(curC != tC) {
                    res.add(m[dR][curC]);
                    // System.out.print(m[dR][curC] + "");
                    curC--;
                }
                while(curR != tR) {
                    res.add(m[curR][tC]);
                    // System.out.print(m[dR][curC] + "");
                    curR--;
                }
                return res;
            }

        }

    public static void main(String[] args) {
        int[][] input = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
        Leetcode54 res = new Leetcode54();
        System.out.println(res.spiralOrder(input));
        }
}

