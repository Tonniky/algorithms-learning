package group_interview.meituan;

public class findMax {

    public int findMax(int[] arr) {
        if (arr == null || arr.length < 3) {
            return new Exception();
        }
        return find(arr, 0, len - 1);
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
    }
}
