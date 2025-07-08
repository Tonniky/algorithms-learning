package interviewCompany.Huawei.aTypeCode;

import chapter_9_others.Problem_25_MadianQuick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class zuiyuanjuli12 {

    public static void main(String[] args) {
        int n = 5;

        int[] arr = {1, 3, 4, 1, 5};
        System.out.println(getLongestDistance(arr));
    }

    private static int getResult(int[] arr) {
        HashMap<Integer, LinkedList<Integer>> idx = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            idx.putIfAbsent(num, new LinkedList<>());
            idx.get(num).add(i);
        }

        int ans = -1;

        for (Integer k: idx.keySet()) {
            LinkedList<Integer> link = idx.get(k);
            if (link.size() > 1) {
                ans = Math.max(ans, link.getLast() - link.getFirst());
            }
        }

        return ans;
    }


    private static int getLongestDistance(int[] arr) {
        HashMap<Integer, LinkedList<Integer>> idx = new HashMap<>();

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            idx.putIfAbsent(num, new LinkedList<>());
            idx.get(num).add(i);
        }

        for (Integer c: idx.keySet()) {
            LinkedList<Integer> linkedList = idx.get(c);
            if (linkedList.size() > 1) {
                ans = Math.max(ans, linkedList.getLast() - linkedList.getFirst());
            }
        }
        return ans;
    }
}
