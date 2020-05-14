package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode77 {
    public List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;

    public void cover(int first,LinkedList<Integer> cur) {
        if(cur.size() == k) {
            output.add((cur));
        }
        for (int i = first; i <= n; i++) {
            cur.add(i);

            cover(i+1, cur);

            cur.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n ;
        this.k = k;
        cover(1,new LinkedList<>());
        return output;
    }

    public List<List<Integer>> combine1(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            output.add(new LinkedList(nums.subList(0, k)));
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }

    public static void main(String[] args) {
        Leetcode77 res = new Leetcode77();
        res.combine1(4,2);
    }


    }
