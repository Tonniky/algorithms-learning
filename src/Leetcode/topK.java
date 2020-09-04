package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//找到最大的
public class topK {
    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //最后这个堆中的元素就是前最大的10W个。时间复杂度为O(N lgm）。
        int index = 0;
        int[] nums2 = new int[map.size()];
        for(Integer key : map.keySet()) {
            nums2[index++] = key;
        }
        int[] top = top(nums2, k);
        for (int i = 0; i < k; i++) {
            res.add(top[i]);
        }
        return res;
    }


    public int[] top(int[] nums, int k) {
        int[] top = new int[k];
        buildHeap(top); //建立小堆
        for (int i = k + 1; i < nums.length; i++) {
            top[0] = nums[i];
            changgHeap(top, top.length, 0); //依次更新
        }
        return top;
    }

    public void buildHeap(int[] top) {
        int index = 0;
        for(int i = top.length / 2 -1; i >= 0; i--) {
            changgHeap(top, top.length, i);
        }
    }

    public void changgHeap(int[] nums,int size, int index) {
        int min = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && nums[left] < nums[min]) min = left;
        if (right < size && nums[right] < nums[min]) min = right;
        if (min != index) {
            int temp = nums[min];
            nums[min] = nums[index];
            nums[index] = temp;
            changgHeap(nums, size, min);
        }
    }


    }
