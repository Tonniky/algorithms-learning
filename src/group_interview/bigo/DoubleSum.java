package group_interview.bigo;

import com.sun.tools.corba.se.idl.IncludeGen;

import java.util.ArrayList;
import java.util.*;

public class DoubleSum {

    public List<Integer> doubleSum(int[] arr) throws Exception{
        if (arr == null || arr.length < 2) {
            try {
                return new ArrayList<Integer>();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int len = arr.length;  // n * log(n)
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int sumMin = 0;
        int indexMinSum = 0;
        int indexMaxSum = 0;
        for (int i = 1; i < len; i++) {   // n的时间复杂度

            // 统计值
            if (arr[i] == arr[0]) {
                indexMinSum++;
            }
            if (arr[i] == arr[len - 1] && i != (len - 1)) {
                indexMaxSum++;
            }

            if (arr[i] - arr[i - 1] < min) {
                min = arr[i] - arr[i - 1];
                sumMin = 1;
            } else if (arr[i] - arr[i - 1] == min) {
                sumMin++;
            }
            continue;
        }
        List<Integer> res = new ArrayList<>();
        res.add(sumMin);
        res.add(indexMaxSum * indexMinSum);
        return res;
    }
}
