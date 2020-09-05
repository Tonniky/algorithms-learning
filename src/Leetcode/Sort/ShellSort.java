package Leetcode.Sort;

public class ShellSort {
    //希尔排序 时间复杂度 0(n*log(n))
    // https://www.cnblogs.com/guoyaohua/p/8600214.html
    public void ShellSort(int[] array) {
        if (array == null || array.length == 0) {
        }
        int len = array.length;
        int temp, gap = len / 2;
        while(gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while(array[preIndex] > temp && preIndex > 0) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        ShellSort out = new ShellSort();
        int[] in = {3,2,1};
        out.ShellSort(in);
        System.out.printf("1");
    }
}
