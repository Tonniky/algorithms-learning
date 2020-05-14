package Leetcode;

import java.util.HashMap;

public class Leetcode79 {
//    public boolean exist(char[][] board, String word) {
//        if (board.length == 0 || word.length() == 0) {
//            return false;
//        }
//        HashMap<Integer,Integer> temp = new HashMap<>();
//        int row = board.length;
//        int col = board[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (board[i][j] == word.charAt(0)) {
//                    temp.put(i, j);
//                }
//            }
//        }
//        if (temp.size() == 0)
//            return false;
//       temp.forEach((key,value) ->{
//           int x = key;
//           int y = value;
//           while()
//               }
//       );
//
//    }

    private boolean[][] marked;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private String word;
    private char[][] board;



        public boolean exist(char[][] board, String word) {
            m = board.length;
            if (m == 0) {
                return false;
            }
            n = board[0].length;
            this.word = word;
            this.board = board;
            marked = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j] == word.charAt(0) && dfs(word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(String word, int i, int j, int start) {
            if(word.length() - 1 == start) {
                return board[i][j] == word.charAt(start);
            }
            if(board[i][j] == word.charAt(start)) {
                marked[i][j] = true;
                for (int k = 0; k < 4; k++) {
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    if (isValid(newX, newY) && !marked[newX][newY]) {
                        if(dfs(word, newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
            }
            marked[i][j] = false;
            return false;
        }

        public boolean isValid(int i, int j) {
            return 0 <= i && i < m && 0 <= j && j < n;
        }


    public static void main(String[] args) {
        Leetcode79 out = new Leetcode79();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        out.exist(board, word);
    }




}
