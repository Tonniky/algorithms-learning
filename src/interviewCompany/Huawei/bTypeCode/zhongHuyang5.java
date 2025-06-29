package interviewCompany.Huawei.bTypeCode;

import java.util.Arrays;
import java.util.Scanner;

public class zhongHuyang5 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int total = sc.nextInt();
//
//        int deadCount = sc.nextInt();
//
//        int[] nums= new int[total];
//
//        Arrays.fill(nums, 0);
//
//        for (int i = 0; i < deadCount; i++) {
//            int num = sc.nextInt();
//            nums[num - 1] = 1;
//        }
//
//        int supplementCount = sc.nextInt();
//
//        int left = 0;
//        int maxLen = 0;
//        int sumLeft = 0;
//        int sumRight = 0;
//
//        for (int right = 0; right < total; right++) {
//            // 更新右边界的未成活树数量
//            sumRight += nums[right];
//            // 遍历所有树，right代表滑动窗口的右边界。
//            while (sumRight - sumLeft > supplementCount) {
//                sumLeft += nums[left]; // 缩小窗口，左边界右移
//                left++;
//            }
//
//            // 更新最大成活区的长度
//            maxLen = Math.max(maxLen, right - left + 1);
//        }
//
//        System.out.println(maxLen);
//    }

    public static void main(String[] args) {

        int total = 5;

        int[] nums = new int[total];
        Arrays.fill(nums, 0);

        nums[1] = 1;
        nums[3] = 1;

        int supplyCount = 1;

        int left = 0;
        int leftSum = 0;
        int rightSum = 0;
        int sumMax = 0;

        for (int right = 0; right < total; right++) {
            rightSum += nums[right];
            while (rightSum - leftSum > supplyCount) {
                leftSum += nums[left];
                left++;
            }

            sumMax = Math.max(right - left + 1, sumMax);
        }
        System.out.println(sumMax);
    }

}
