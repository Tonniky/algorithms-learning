package Leetcode.Sort;
import java.util.*;
public class QuickSort {
    //快速排序
    public static void quickSort(int[] array) {
        qSort(array,0, array.length - 1);
    }

    public static void qSort(int[] array,int left, int right) {
        if (array == null || array.length <= 1 || right <= left)
            return ;
        int middle = partion(array,left,right);
        qSort(array,left,middle);
        qSort(array,middle + 1,right);
    }

    public static int partion(int[] array, int left, int right) {
        int temp = array[left];
        if (temp < array[right] && left < right) {
            right--;
        }

        if (left < right) {
            array[left] = array[right];
            ++left;
        }

        if (temp > array[left] && left < right) {
            left++;
        }

        if (left < right) {
            array[right] = array[left];
            right--;
        }
        array[left] = temp;
        return left;
    }
}
