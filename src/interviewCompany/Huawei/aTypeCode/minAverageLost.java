package interviewCompany.Huawei.aTypeCode;

import java.util.ArrayList;
import java.util.StringJoiner;

public class minAverageLost {
    public static void main(String[] args) {
        int tolteratedNum = 3;

        Integer[] failNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int len = failNum.length;

        int[] cumulativeSum = new int[len];
        cumulativeSum[0] = failNum[0];

        for (int i = 1; i < len; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + failNum[i];
        }

        ArrayList<Integer> validPeriods = new ArrayList<>();
        int maxLength = 0;

        for (int start = 0; start < len; start++) {
            for (int end = start; end < len; end++) {
                int sum = cumulativeSum[end] - (start == 0 ? 0 : cumulativeSum[start - 1]);
                int length = end - start + 1;
                if (sum >= tolteratedNum * length) {
                    validPeriods.add(length);
                    maxLength = Math.max(maxLength, length);
                }
                if (maxLength == length) {
                    validPeriods.add(start);
                    validPeriods.add(end);
                }
            }
        }

        if (validPeriods.size() == 0) {
            System.out.println("NULL");
        } else {
            StringJoiner sj = new StringJoiner(" ");
            for (int i = 0; i < validPeriods.size(); i += 2) {
                sj.add(validPeriods.get(i) + "-" + validPeriods.get(i + 1));
            }
            System.out.println(sj.toString());
        }
    }
}
