package interviewCompany.Huawei.aTypeCode;

import java.util.Arrays;
import java.util.Scanner;

public class zhonghuyang4 {

    //
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int total = in.nextInt();
        int deadCount = in.nextInt();

        int[] nums = new int[total];

        Arrays.fill(nums, 0);

        for (int i = 0; i < deadCount; i++) {
            int num = in.nextInt();
            nums[num - 1] = 1;
        }

        int supplementCount = in.nextInt();

        int left = 0;
        int maxLen = 0;
        int sumLeft = 0;
        int sumRight = 0;

        for (int right = 0; right < total; right++) {
            sumRight += nums[right];

            while (sumRight -sumLeft > supplementCount) {
                sumLeft += nums[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println(maxLen);
    }


}
