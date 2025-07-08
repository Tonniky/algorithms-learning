package interviewCompany.Huawei.aTypeCode;

import java.math.BigInteger;
import java.util.EnumSet;

public class jisuanshuzuweizhi13 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 3, 5, 6};
        System.out.println(getResult(arr));
    }

    private static int getResult(int[] arr) {
        BigInteger fact = BigInteger.valueOf(1);

        for (Integer num: arr) {
            fact = fact.multiply(BigInteger.valueOf(num));
        }

        BigInteger left = BigInteger.valueOf(1);
        BigInteger right = fact.divide(BigInteger.valueOf(arr[0]));

        if (left.compareTo(right) == 0) {
            return 0;
        }

        for (int i = 1; i < arr.length; i++) {
            left = left.multiply(BigInteger.valueOf(arr[i - 1]));
            right = right.divide(BigInteger.valueOf(arr[i]));

            if (left.compareTo(right) == 0)
                return i;
        }
        return -1;
    }




}
