package interviewCompany.Huawei.aTypeCode;

public class zuijiandan14 {

    public static void main(String[] args) {

    }

    private static int getResult(Integer[] arr) {
        int len = arr.length;
        double minDiff = Integer.MAX_VALUE;
        Integer ans = null;

        for (int k = -127; k <= 128; k++) {
            double sum = 0;
            for (Integer val : arr) {
                int newVal = val + k;
                newVal = Math.max(0, Math.min(newVal, 255));
                sum += newVal;
            }

            double diff = Math.abs(sum / len - 128);

            if (diff < minDiff) {
                minDiff = diff;
                ans = k;
            } else if (diff == minDiff && ans != null) {
                ans = Math.min(ans, k);
            }
        }
        return ans;
    }
}
