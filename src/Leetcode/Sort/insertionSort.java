package Leetcode.Sort;

public class insertionSort {

   //插入排序 时间复杂度O(n*n)
    public int[] insertionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int len = array.length;
        int current;
        for (int i = 1; i < len; i++) {
            current = array[i];
            int preIndex = i - 1;
            while (array[preIndex] > current && preIndex > 0) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex] = current;
        }
        return array;
    }
}
