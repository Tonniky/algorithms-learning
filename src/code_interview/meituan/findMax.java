package code_interview.meituan;

public class findMax {

    public int findMax(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        return find(arr, 0,  arr.length - 1);
    }

    public int find (int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1] ) {
            return mid;
        }
        if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
             find(arr, mid, right);
        }
        if(arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
            find(arr, left, mid);
        }
        return mid;
    }
}
