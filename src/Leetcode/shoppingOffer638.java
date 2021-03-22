package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class shoppingOffer638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }

        for (List<Integer> item : special) {
            List<Integer> es = new ArrayList<>(needs);
            int j;
            for (j = 0; j < needs.size(); j++) {
                int diff = es.get(j) - item.get(j);
                if (diff < 0) {
                    break;
                }
                es.set(j, diff);
            }

            if (j == needs.size()) {
                res = Math.min(res, item.get(j) + dfs(price, special, es));
            }
        }
        return res;
    }


    public int shoppingOffers1(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        return dfs(price, special, needs, map);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        int res = 0;
        for (int i = 0 ; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }

        for (List<Integer> s : special) {
            List<Integer> es = new ArrayList<>();
            int j = 0;
            for (j = 0; j < needs.size(); j++) {
                int diff = es.get(j) - needs.get(j);
                if (diff < 0) {
                    break;
                }

                es.set(j, diff);
            }

            if (j== needs.size()) {
                res = Math.min(res, s.get(j) + dfs(price, special, es, map));
            }
        }
        map.put(needs, res);
        return res;
    }
}
