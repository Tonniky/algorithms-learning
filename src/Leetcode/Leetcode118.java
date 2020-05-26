package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    public List<List<Integer>> generate(int numRows){
        if (numRows == 0) {
            return new ArrayList<>();
        }
    List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
    for (int i = 1; i < numRows; i++) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int j = 0; j < i + 1; j++) {
            if(j == 0 || j == i) {
                temp.add(1);
            } else {
                temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
        }
        res.add(temp);
    }
    return res;
    }
    }
