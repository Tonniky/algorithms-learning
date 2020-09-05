package Leetcode.Sort;

public class bubbleSort {
    public int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j < len - i; j++) {
                if (array[i - 1] >array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
