package code_interview.baidu;

public class QuickSort {


    public  int[] quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        return quick(arr, 0, arr.length);
    }



    public int[] quick(int[] arr, int start, int right) {
        if (start > right) {
            return arr;
        }
        int len = arr.length;
        int index = partion(arr, 0, len - 1);
        quick(arr, 0, index - 1);
        quick(arr, index + 1, right);
        return arr;
    }



    //
    public int partion (int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            while (left < right && arr[left] <= temp) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        arr[left] = temp;
        return left;
    }


}
