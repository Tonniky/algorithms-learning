package Leetcode;

public class Leetcode149 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode (int data) {
            this.val = data;
        }
    }
    public int maxPoints(int[][] points) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < points.length; i++) {
            if (row < points[i][0]) {
                row = points[i][0];
            }
            if(col < points[i][1]) {
                col = points[i][1];
            }
        }
        int[][] first = new int[row + 1][col + 1];
        int[][] second = new int[row + 1][col + 1];
        for (int i = 0; i < points.length; i++) {
            first[points[i][0]][points[i][1]] += 1;
            second[points[i][0]][points[i][1]] += 1;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                first[i][j] = first[i - 1][j - 1] != 0 ? (first[i - 1][j -1] + 1) : first[i][j];
            }
        }
        for (int i = 1; i <= col; i++) {
            for (int j = 1; j < row; j++) {
                second[j][i] = second[j + 1][i - 1] != 0 ? (second[j + 1][i - 1] + 1) : second[j][i];
            }
        }
        int fmax = 0;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                fmax = Math.max(Math.max(fmax,first[i][j]),second[i][j]);
            }
        }
        return fmax;
    }

    public static void main(String[] args) {
        int[][] input = {{0,0},{0,0}};
        Leetcode149 le = new Leetcode149();
        le.maxPoints(input);
    }
    }
