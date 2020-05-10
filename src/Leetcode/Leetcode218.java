package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//
public class Leetcode218 {

    public List<int[]> getSkyline(int[][] buildings) {
        return merge(buildings, 0, buildings.length-1);
    }

    private LinkedList<int[]> merge(int[][] buildings, int lo, int hi) {
        LinkedList<int[]> res = new LinkedList<>();
        if(lo > hi) {
            return res;
        } else if(lo == hi) {
            res.add(new int[]{buildings[lo][0], buildings[lo][2]});
            res.add(new int[]{buildings[lo][1], 0});
            return res;
        }
        int mid = lo+(hi-lo)/2;
        LinkedList<int[]> left = merge(buildings, lo, mid);
        LinkedList<int[]> right = merge(buildings, mid+1, hi);
        int leftH = 0, rightH = 0;
        while(!left.isEmpty() || !right.isEmpty()) {
            long x1 = left.isEmpty()? Long.MAX_VALUE: left.peekFirst()[0];
            long x2 = right.isEmpty()? Long.MAX_VALUE: right.peekFirst()[0];
            int x = 0;
            if(x1 < x2) {
                int[] temp = left.pollFirst();
                x = temp[0];
                leftH = temp[1];
            } else if(x1 > x2) {
                int[] temp = right.pollFirst();
                x = temp[0];
                rightH = temp[1];
            } else {
                x = left.peekFirst()[0];
                leftH = left.pollFirst()[1];
                rightH = right.pollFirst()[1];
            }
            int h = Math.max(leftH, rightH);
            if(res.isEmpty() || h != res.peekLast()[1]) {
                res.add(new int[]{x, h});
            }
        }
        return res;
    }

    public List<List<Integer>> getSkyline2(int[][] buildings) {
        if(buildings.length == 0){
            return  new ArrayList<>();
        }
        return merge2(buildings, 0, buildings.length - 1);
    }

    private List<List<Integer>> merge2(int[][] buildings, int start, int end) {

        List<List<Integer>> res = new ArrayList<>();
        //只有一个建筑, 将 [x, h], [y, 0] 加入结果
        if (start == end) {
            List<Integer> temp = new ArrayList<>();
            temp.add(buildings[start][0]);
            temp.add(buildings[start][2]);
            res.add(temp);

            temp = new ArrayList<>();
            temp.add(buildings[start][1]);
            temp.add(00);
            res.add(temp);
            return res;
        }
        int mid = (start + end) >>> 1;
        //第一组解
        List<List<Integer>> Skyline1  = merge2(buildings, start, mid);
        //第二组解
        List<List<Integer>> Skyline2  = merge2(buildings, mid + 1, end);
        //下边将两组解合并
        int h1 = 0;
        int h2 = 0;
        int i = 0;
        int j = 0;
        while (i < Skyline1 .size() || j < Skyline2 .size()) {
            long x1 = i < Skyline1 .size() ? Skyline1 .get(i).get(0) : Long.MAX_VALUE;
            long x2 = j < Skyline2 .size() ? Skyline2 .get(j).get(0) : Long.MAX_VALUE;
            long x = 0;
            //比较两个坐标
            if (x1 < x2) {
                h1 = Skyline1 .get(i).get(1);
                x = x1;
                i++;
            } else if (x1 > x2) {
                h2 = Skyline2 .get(j).get(1);
                x = x2;
                j++;
            } else {
                h1 = Skyline1 .get(i).get(1);
                h2 = Skyline2 .get(j).get(1);
                x = x1;
                i++;
                j++;
            }
            //更新 height
            int height = Math.max(h1, h2);
            //重复的解不要加入
            if (res.isEmpty() || height != res.get(res.size() - 1).get(1)) {
                List<Integer> temp = new ArrayList<>();
                temp.add((int) x);
                temp.add(height);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
