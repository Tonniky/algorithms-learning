package Leetcode.Sort;

public class HeapSort {
    //堆排序  时间复杂度：0（o log (n)）
    public int[] HeapSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        buildHeap(array);  //建一个堆
        //开始进行排序
        int len = array.length;
        while(len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0,len);  //重新开始
        }
        return array;
    }

    public void swap (int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public void buildHeap(int[] array) {
        int len = array.length;
        for (int i = len / 2 - 1; i > 0; i--) {
            adjustHeap(array, i, len);
        }
    }

    //维护的是一个最大堆
    public void adjustHeap(int[] array, int i, int size) {
        int minIndex = i;
        if (array[i] < array[2 * i + 1] && (2 * i + 1 ) < size) {
            minIndex = 2 * i +1;
        }
        if (array[i] < array[2 * i + 2] && (2 * i + 2) < size) {
            minIndex = 2 * i + 2;
        }

        if (minIndex != i) {
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            adjustHeap(array, minIndex, size);
        }
    }

}
