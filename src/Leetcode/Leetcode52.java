package Leetcode;

public class Leetcode52 {
    public int totalQueens(int n) {
        if(n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    public int process1(int i, int[] record, int n) {
        if(i == n) {
            return 1;
        }
        int res = 0;
        for(int j = 0; j < n; j++) {
            if(isValid(record, i, j)) {
                record[i] = j;
                res += process1(i+1, record, n);
            }
        }
        return res;
    }

    public boolean isValid(int[] records, int i, int j) {
        for(int k = 0; k < i; i++) {
            if(j == records[k] || Math.abs(records[k] - j) == Math.abs(i-k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode52 leetcode = new Leetcode52();
        int res = leetcode.totalQueens(5);
        System.out.println(res);
    }
}
