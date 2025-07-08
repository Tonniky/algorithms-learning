package hot100;

import com.sun.org.apache.xml.internal.utils.res.XResources_es;

import java.util.*;

public class swapParis {

    public static void main(String[] args) {
        int[] arr = {23,24,25,21,19,22,26,23};

        System.out.print(getMinDis(arr));
//        int[] res = getFindMinDistance2(arr);
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + ",");
//        }
    }

    private static List<Integer> getFindMinDistance(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int cur = arr[i];
            boolean flag = true;

            for (int j = i + 1; j < n; j++) {
                if (cur < arr[j] && flag) {
                    int dis = j - i;
                    res.add(dis);
                    flag = false;
                }
                if (flag && j == n - 1) {
                    res.add(0);
                }
            }

        }
        res.add(0); // 最后一个
        return res;
    }

    private static int[] getFindMinDistance2(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 存储索引

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return res;
    }


    private static int[] getMinDis(int[] arr) {

        int n = arr.length;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && arr[i] > arr[queue.peek()]) {
                int cur = queue.poll();
                res[cur] = i - cur;
            }
            queue.add(i);
        }
        return res;
    }

}
