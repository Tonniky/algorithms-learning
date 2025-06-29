package interviewCompany.Huawei.bTypeCode;

import java.util.Arrays;
import java.util.Scanner;

public class calc5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vals = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] cols = sc.nextLine().split(" ");
        System.out.println();
    }


    static class Tile {
        int val;
        int col;

        public Tile(int val, String col) {
            this.val = val;
            this.col = col.charAt(0);
        }
    }

    public static int calc(int[] vals, String[] cols) {
        int len = vals.length;
        Tile[] tiles = new Tile[len];

        for (int i = 0; i < len; i++) {
            tiles[i] = new Tile(vals[i], cols[i]);
        }

        int[] maxChain = {0};
        boolean[] vis = new boolean[len];

        search(tiles, vis, null, 0, maxChain);

        return maxChain[0];
    }

    public static void search(Tile[] tiles, boolean[] vis, Tile prev, int len, int[] maxChain) {
        maxChain[0] = Math.max(maxChain[0], len);

        for (int i = 0; i < tiles.length; i++) {
            if (vis[i]) continue;

            Tile cur = tiles[i];

            if (prev != null && prev.val != cur.val && prev.col != cur.col) continue;

            vis[i] = true;
            search(tiles, vis, cur, len + 1, maxChain);
            vis[i] = false;
        }
    }
}
