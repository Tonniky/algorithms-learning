package Leetcode;


import java.util.ArrayList;
import java.util.List;

public class findSubsequences491 {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0);
        return new ArrayList<>(ret);
    }
    public void dfs(int[] nums, List<Integer> tmp, int index) {
        if (index >= nums.length) {
            if (tmp.size() >= 2) {
                ret.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (tmp.size() == 0 || nums[index] >= tmp.get(tmp.size() - 1)) {
            tmp.add(nums[index]);
            dfs(nums, tmp, index + 1);
            tmp.remove(tmp.size() - 1);
        }
        if (index > 0 && !tmp.isEmpty() && nums[index] == tmp.get(tmp.size() - 1)) {
            return;
        }
        dfs(nums, tmp, index + 1);
    }

    public static void main(String[] args) {
        int[] tes = {4, 7, 7};
        findSubsequences491 out = new findSubsequences491();
        out.findSubsequences(tes);
    }
    }

