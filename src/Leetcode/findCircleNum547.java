package Leetcode;
import java.util.*;

public class findCircleNum547 {

    //dfs 解法
    public int findCircleNum(int[][] M) {
        int len = M.length;
        int[] con = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(con[i] == 0) {
                dfs(M, i, con);
                count++;
            }
        }
        return count;
    }


    public static void dfs(int[][] M, int i, int[] con) {
        for (int m = 0; m < con.length; m++) {
            if (M[m][i] == 1 && con[m] == 0) {
                con[m] = 1;
                dfs(M, m, con);
            }
        }
    }


    public int findCircleNum2(int[][] M) {
        int len = M.length;
        int[] visited = new int[len];
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while(!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < len; j++) {
                        if(M[s][j] == 1 && visited[j] == 0) {
                            visited[j] = 1;
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    }
