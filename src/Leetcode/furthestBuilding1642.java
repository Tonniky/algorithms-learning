package Leetcode;

public class furthestBuilding1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, sum = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            int h = heights[i] - heights[i - 1];
            if (h > 0) {
                queue.add(h);
                if (queue.size() > ladders) {
                    sum += queue.poll();
                }
                if (sum > bricks) {
                    return i - 1;
                }
            }
        }
        return n - 1;
    }






    private int ans;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        dfs(heights, 0, bricks, ladders);
        return ans;
    }

    public void dfs(int[] heights, int cur, int bricks, int ladders) {
        if (ans == heights.length - 1)
            return ;
        if (cur == heights.length - 1 || (heights[cur + 1] - heights[cur] > bricks && ladders == 0)) { // 退出机制
            ans = Math.max(ans, cur);
            return;
        }
        if (heights[cur + 1] <= heights[cur]) {
            dfs(heights, cur + 1, bricks, ladders);
        } else {
            if (bricks >= heights[cur + 1] - heights[cur])
                dfs(heights, cur + 1, bricks + heights[cur] - heights[cur + 1], ladders);
            if (ladders >= 1)
                dfs(heights, cur + 1, bricks, ladders - 1);
        }
    }

    }
