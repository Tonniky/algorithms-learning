package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        for (int i = 1; i < rowIndex; i++) {
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
        return res.get(rowIndex - 1);
    }

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            res.add(1);
            for(int j = i - 1; j > 0; j--){
                res.set(j, (res.get(j) + res.get(j - 1)));
            }
        }
        return res;
    }

}
