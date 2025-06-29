package interviewCompany.Huawei.bTypeCode;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLFault;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class jiqirenArea20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        int m = in.nextInt();
//        int n = in.nextInt();
//
//        int[][] grid = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                grid[i][j] = in.nextInt();
//            }
//        }

        int m = 4;
        int n = 4;
        int[][] grid = {{1, 2, 5, 2}, {2, 4, 4, 5},
                        {3, 5, 7, 1}, {4, 6, 2, 4}
        };
        System.out.println(getMaxSize(m, n, grid));

    }

    private static int getResult(int[][] grid, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int maxSize = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int size = bfs(grid, visited, i, j, m, n, dirs);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    private static int bfs(int[][] grid, boolean[][] visited, int x, int y, int m, int n, int[][] dirs) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] points = queue.poll();

            for (int[] dir: dirs) {
                int newX = points[0] + dir[0];
                int newY = points[1] + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] &&
                Math.abs(grid[points[0]][points[1]] - grid[newX][newY]) <= 1) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                    size++;
                }
            }
        }
        return size;
    }

    private static int getMaxSize(int m, int n, int[][] grid) {
        boolean[][] visited = new boolean[m][n];
        int maxSize = 0;
        int[][] oriention = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int size = getCurrentSizeByBFS(i, j, m, n, grid, visited, oriention);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    private static int getCurrentSizeByBFS(int x, int y, int m, int n, int[][] grid, boolean[][] visited, int[][] oriention) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] points = queue.poll();

            for (int[] dir: oriention) {
                int newX = points[0] + dir[0];
                int newY = points[0] + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && Math.abs(grid[newX][newY] - grid[points[0]][points[1]]) <= 1
                 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    size++;
                    visited[newX][newY] = true;
                }
            }
        }
        return size;
    }



}
