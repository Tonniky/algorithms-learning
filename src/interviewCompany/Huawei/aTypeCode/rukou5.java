package interviewCompany.Huawei.aTypeCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringJoiner;

public class rukou5 {

    static int n;
    static int m;
    static String[][] matrix;
    static int[][] offset = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static HashSet<String> checked = new HashSet<>();

    public static void main(String[] args) {
        n = 4;
        m = 5;

        matrix = new String[][]{{"X", "X", "X", "X", "X"}, {"O", "O", "O", "O", "X"}, {"X", "O", "O", "O", "X"}, {"X", "O", "X", "X", "O"}};

        System.out.println(getResult(matrix, n, m));

    }

    private static String getResult(String[][] matrix, int n, int m) {
        ArrayList<Integer[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j  = 0; j < m; j++) {
                if ("O".equals(matrix[i][j]) && !checked.contains(i + "-" + j)) {
                    ArrayList<Integer[]> enter = new ArrayList<>();
                    int count = dfs(i, j, 0, enter);
                    if (enter.size() == 1) {
                        Integer[] pos = enter.get(0);
                        Integer[] an = {pos[0], pos[1], count};
                        ans.add(an);
                    }
                }
            }
        }

        if (ans.size() == 0)
            return "NULL";

        ans.sort((a, b) -> b[2] - a[2]);

        if (ans.size() == 1 || ans.get(0)[2] > ans.get(1)[2]) {
            StringJoiner stringJoiner = new StringJoiner(" ", "", "");
            for (Integer ele: ans.get(0)) {
                stringJoiner.add(ele + "");
            }
            return stringJoiner.toString();
        } else {
            return ans.get(0)[2] + "";
        }
    }

    private static int dfs(int i, int j, int count, ArrayList<Integer[]> enter) {
        String pos = i + "-" + j;
        if (i < 0 || i >= n || j < 0 || j >= m || "X".equals(matrix[i][j]) || checked.contains(pos)) {
            return count;
        }

        checked.add(pos);

        if (i == 0 || i == n - 1 || j == 0 || j == m - 1)
            enter.add(new Integer[]{i, j});

        count++;

        for (int k = 0; k < offset.length; k++) {
            int offsetX = offset[k][0];
            int offsetY = offset[k][1];

            int newI = i + offsetX;
            int newJ = j + offsetY;

            count = dfs(newI, newJ, count, enter);
        }
        return count;
    }

}
