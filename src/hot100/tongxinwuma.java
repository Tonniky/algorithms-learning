package hot100;

import java.util.ArrayList;
import java.util.HashMap;

public class tongxinwuma {
    public static void main(String[] args) {


        int n = 5;
        int[] arr = {1, 2, 2, 4, 1};
        System.out.print(getResult(arr));

    }

    private static int getResult(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> idxs = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer code = arr[i];
            idxs.putIfAbsent(code, new ArrayList<>());
            idxs.get(code).add(i);
        }

        int maxSize = 0;
        int minLen = 0;

        for (ArrayList<Integer> value: idxs.values()) {
            int size = value.size();
            int len = value.get(value.size() - 1) - value.get(0) + 1;

            if (size > maxSize || (size == maxSize && len < minLen)) {
                maxSize = size;
                minLen = len;
            }
        }

        return minLen;
    }
}
