package Leetcode;
import java.util.*;
public class minimumEffortPath5548 {
    int[][] ori = {{0,-1}, {0,1}, {1,0}, {-1,0}};
    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1000000;
        while(left < right) {
            int mid = (left + right) >>> 1;
            if (dfs(0, 0, mid, heights, new boolean[heights.length][heights[0].length])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean dfs(int x, int y, int max, int[][] heights, boolean[][] visited) {
        if (x == heights.length - 1 && y == heights[0].length - 1) {
            return true;
        }
        visited[x][y] = true;
        for(int[] res: ori) {
            int nx = x + res[0];
            int ny = y + res[1];
            if (0 <= nx && nx < heights.length && 0 <= ny && ny < heights[0].length &&
                    !visited[nx][ny] && Math.abs(heights[nx][ny] - heights[x][y]) <= max) {
                if (dfs(nx, ny, max, heights, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

}
