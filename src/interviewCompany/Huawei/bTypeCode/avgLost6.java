package interviewCompany.Huawei.bTypeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class avgLost6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int toleratedAvergeLoss = Integer.parseInt(in.nextLine());

        Integer[] failureRates = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int arrayLength = failureRates.length;

        int[] cumulativeSum = new int[arrayLength];

        cumulativeSum[0] = failureRates[0];
        for (int i = 1; i < arrayLength; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + failureRates[i];
        }

        ArrayList<Integer[]> validPeriods = new ArrayList<>();

        int maxLength = 0;
        for(int start = 0; start < arrayLength; start++) {
            for (int end = start; end < arrayLength; end++) {
                int sum = start == 0 ? cumulativeSum[end] : cumulativeSum[end] - cumulativeSum[start - 1];
                int length = end - start + 1;
                int toleratedLoss = length * toleratedAvergeLoss;

                if (sum <= toleratedLoss) {
                    if (length > maxLength) {
                        validPeriods = new ArrayList<>();
                        validPeriods.add(new Integer[]{start, end});
                        maxLength = length;
                    } else if (length == maxLength) {
                        validPeriods.add(new Integer[]{start, end});
                    }
                }
            }
        }

        if (validPeriods.size() == 0) {
            System.out.println("NULL");
        } else {
            validPeriods.sort((a, b) -> a[0] - b[0]);

            StringJoiner sj = new StringJoiner(" ");
            for (Integer[] period: validPeriods)
                sj.add(period[0] + "-" + period[1]);
            System.out.println(sj.toString());
        }

    }
}
