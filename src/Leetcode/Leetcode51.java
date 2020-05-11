package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 时间复杂度：O(N!)放置第 1 个皇后有 N 种可能的方法，放置两个皇后的方法不超过 N (N - 2) ，放置 3 个皇后的方法不超过 N(N - 2)(N - 4) ，以此类推。总体上，时间复杂度为
 * O(N!)O(N!).空间复杂度：O(N)
 * O(N) . 需要保存对角线和行的信息。
 *
 */


public class Leetcode51 {

    private List<List<String>> output = new ArrayList<>();

    // 用于标记是否被列方向的皇后被攻击
    int[] rows;
    // 用于标记是否被主对角线方向的皇后攻击
    int[] mains;
    // 用于标记是否被次对角线方向的皇后攻击
    int[] secondary;
    // 用于存储皇后放置的位置
    int[] queens;

    int n;

    public List<List<String>> solveNQueens(int n) {
        // 初始化
        rows = new int[n];
        mains = new int[2 * n - 1];
        secondary = new int[2 * n - 1];
        queens = new int[n];
        this.n = n;

        // 从第一行开始回溯求解 N 皇后
        backtrack(0);

        return output;
    }

    // 在一行中放置一个皇后
    private void backtrack(int row) {
        if (row >= n) return;
        // 分别尝试在 row 行中的每一列中放置皇后
        for (int col = 0; col < n; col++) {
            // 判断当前放置的皇后不被其他皇后的攻击
            if (isNotUnderAttack(row, col)) {
                // 选择，在当前的位置上放置皇后
                placeQueen(row, col);
                // 当当前行是最后一行，则找到了一个解决方案
                if (row == n - 1) addSolution();
                // 在下一行中放置皇后
                backtrack(row + 1);
                // 撤销，回溯，即将当前位置的皇后去掉
                //我们来想象一下，当在棋盘上放置了几个皇后且不会相互攻击。但是选择的方案不是最优的，因为无法放置下一个皇后。
                // 此时我们该怎么做？回溯。意思是回退一步，来改变最后放置皇后的位置并且接着往下放置。如果还是不行，再 回溯。
                removeQueen(row, col);
            }
        }
    }

    // 判断 row 行，col 列这个位置有没有被其他方向的皇后攻击
    private boolean isNotUnderAttack(int row, int col) {
        // 判断的逻辑是：
        //      1. 当前位置的这一列方向没有皇后攻击
        //      2. 当前位置的主对角线方向没有皇后攻击
        //      3. 当前位置的次对角线方向没有皇后攻击
        int res = rows[col] + mains[row - col + n - 1] + secondary[row + col];
        // 如果三个方向都没有攻击的话，则 res = 0，即当前位置不被任何的皇后攻击
        return res == 0;
    }

    // 在指定的位置上放置皇后
    private void placeQueen(int row, int col) {
        // 在 row 行，col 列 放置皇后
        queens[row] = col;
        // 当前位置的列方向已经有皇后了
        rows[col] = 1;
        // 当前位置的主对角线方向已经有皇后了
        mains[row - col + n - 1] = 1;
        // 当前位置的次对角线方向已经有皇后了
        secondary[row + col] = 1;
    }

    // 移除指定位置上的皇后
    private void removeQueen(int row, int col) {
        // 移除 row 行上的皇后
        queens[row] = 0;
        // 当前位置的列方向没有皇后了
        rows[col] = 0;
        // 当前位置的主对角线方向没有皇后了
        mains[row - col + n - 1] = 0;
        // 当前位置的次对角线方向没有皇后了
        secondary[row + col] = 0;
    }

    /**
     * 将满足条件的皇后位置放入output中
     */
    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append("*");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append("*");
            solution.add(sb.toString());
        }
        output.add(solution);
    }


    public static void main(String[] args) {
        Leetcode51 leetcode51 = new Leetcode51();
        List<List<String>> res = leetcode51.solveNQueens(5);
        System.out.println("n皇后为" + res);
    }

}
