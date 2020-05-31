package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode216 {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum_dfs(k, n, 1);
        return ans;
    }

    public void combinationSum_dfs(int k, int n, int start) {
        if (k < 0 || n < 0)
            return;
        if (k == 0 && n == 0) {
            if(!path.isEmpty())
                ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < 10; i++) {
            path.push(i);
            combinationSum_dfs(k - 1, n - i, ++start);
            path.pop();
        }
    }

    public static void main(String[] args) {
        Leetcode216 out = new Leetcode216();
        out.combinationSum3(3, 9);
    }

    }


