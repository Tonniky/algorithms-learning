package group_interview.netEase;

public class findMaxLength {


    public int findMaxLen(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        Arrays.sort(arr);
        int res = 0;
        int temp = 1;
        int cur = arr[0];
        for (int i = 1; i < len; i++) {
            if (cur == arr[i]) {
                continue;
            } else if (cur + 1 = arr[i]) {
                temp++;
                cur = arr[i];
            } else if (cur + 1 != arr[i]) {
                res = java.lang.Math.max(temp, res);
                temp = 1;
                cur = arr[i];
            }
        }
        return res;
    }

}
