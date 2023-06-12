package code_interview.baidu;


// heapSort 那么就是建一个最小堆了
public class topK {

    public int[] topK (int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        buildHeap(arr, k);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[(k - 1)/ 2]) {
                swap(arr[i], arr[k - 1] / 2);
                adjust(arr, k, k);  // 进行调整
            }
        }
        return arr;
    }

    public void swap(int arr1, int arr2) {
        int temp = arr1;
        arr1 = arr2;
        arr2 = temp;
    }

    // 小堆的调整
    public void buildHeap(int[] arr, int k) {
        int len = arr.length;
        for (int i = (k - 1)/2; i >= 0; i--) { // 进行调整
            adjust(arr, i, len);
        }
    }

    public void adjust(int[] arr, int i, int k) {

        int minIndex = i;
        if (arr[minIndex] > arr[2 * minIndex - 1] && 2 * minIndex - 1 < k) {
            minIndex = 2 * minIndex - 1;
        }
        if (arr[minIndex] > arr[2 * minIndex - 1] && 2 * minIndex + 1 < k) {
            minIndex = 2 * minIndex + 1;
        }

        if (minIndex != i) {
            int temp = arr[minIndex];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            adjust(arr, minIndex, k);
        }
    }

}
