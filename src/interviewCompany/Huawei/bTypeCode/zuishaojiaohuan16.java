package interviewCompany.Huawei.bTypeCode;

import java.util.Scanner;

public class zuishaojiaohuan16
{

    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        String numStr = in.nextLine();
//        String[] numParts = numStr.split(" ");
//        int[] nums = new int[numParts.length];
//        for (int i = 0; i < numParts.length; i++) {
//            nums[i] = Integer.parseInt(numParts[i]);
//        }
//        int k = in.nextInt();

        int[] nums = {1, 3, 1, 4, 0};
        int k = 2;

        int count = 0;
        for (int num: nums) {
            if (num < k) {
                count++;
            }
        }
        if (count == 1) {
            System.out.println(0);
            return;
        }

        int minSwapCount = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] >= k) {
                minSwapCount++;
            }
        }
        int tmpSwapCount = minSwapCount;
        for (int j = count; j < nums.length; j++) {
            int preLeft = j - count;
            int curRight = j;
            if (nums[preLeft] >= k && nums[curRight] < k) {
                tmpSwapCount--;
            } else if (nums[preLeft] < k && nums[curRight] >= k) {
                tmpSwapCount++;
            }
            minSwapCount = Math.min(minSwapCount, tmpSwapCount);
        }
        System.out.println(minSwapCount);

    }

}
