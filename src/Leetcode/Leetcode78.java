package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0){
            return new LinkedList<>();
        }
        List<List<Integer>> output = new ArrayList<>();
        int len = nums.length;
        for (int i =0; i< (int)Math.pow(2, len); i++) {
           int[] res = covertBit(i, len);
           List<Integer> list = new ArrayList<>();
           for (int j = 0; j < len; j++) {
               if (res[j] != 0) {
                   list.add(nums[j]);
               }
           }
           output.add(list);
        }
        return output;
    }

    public int[] covertBit(int i, int len) {
        int[] temp = new int[len];
        for (int j = 0; j < len; j++) {
            temp[j] = 0;
        }
        if (i == 0) {
            return temp;
        }
        int position = 0;
        while (i != 0) {
            int bit = i % 2;
            i = i / 2;
            temp[position] = bit;
            position++;
        }
        return temp;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    List<List<Integer>> output = new LinkedList<>();
    int k;
    int n;

    public void convert(int[] num, int k, ArrayList<Integer> curr) {
        if (curr.size() == n) {
            output.add(new ArrayList<>(curr));
        }
        for (int j = k; j < num.length; j++) {
            curr.add(num[j]);
            convert(num, j + 1, curr);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        this.k = nums.length;
        for (n = 0; n < k + 1; n++) {
            convert(nums,0, new ArrayList<>());
        }
        return output;
    }

    public static void main(String[] args) {
        Leetcode78 out = new Leetcode78();
        int[] input = {1,2,3};
        out.subsets2(input);
    }
    }
