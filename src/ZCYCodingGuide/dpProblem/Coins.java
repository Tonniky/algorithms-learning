package ZCYCodingGuide.dpProblem;

public class Coins {


    public int coins (int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        return findSum(arr, 0, aim);
    }

    public int findSum(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0 ; i * arr[index] < aim; i++) {
                res += findSum(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }




}
