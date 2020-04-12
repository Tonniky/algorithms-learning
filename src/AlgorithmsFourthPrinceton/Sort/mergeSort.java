package AlgorithmsFourthPrinceton.Sort;

public class mergeSort {

    public static void main(String[] args) {
        int[] in = {5, 4, 4, 7, 8};
        mergeSort(in, 0, in.length-1);
        System.out.println(in);
    }

    public static void mergeSort(int[] a, int start, int end) {
        while(start < end){
            int mid = (start + end)/2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];
        int p1 = left, p2 = mid, k = left;
        while(p1 < mid && p2 < right) {
            if(a[p1] <= a[p2]) {
                tmp[k++] = a[p1++];
            } else {
                tmp[k++] = a[p2++];
            }
        }
        while(p1 <= mid) {
            tmp[k++] = a[p1++];
        }
        while(p2 <= right){
            tmp[k++] = a[p2++];
        }
        for(int i= 0; i < a.length; i++){
            a[i] = tmp[i];
        }
    }
}
