package Leetcode.Sort;

public class selectionSort {

    // 选择排序 ，时间复杂度 0（n*n）
    public int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int indexMin = i;
            for (int j = i; j < len; j++) {
                if (array[indexMin] > array[j]) {
                    indexMin = j;
                }
                int temp = array[indexMin];
                array[indexMin] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
