package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class findTheWinner5727 {
    public int findTheWinner(int n, int k) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            temp.add(i);
        }
        int index = 0;
        while (temp.size() > 1) {
            int delete = (index + k - 1) % temp.size();
            temp.remove(delete);
            index = delete;
        }
        return temp.get(0);
    }
    }
