package interviewCompany.Huawei.aTypeCode;

import java.util.Arrays;
import java.util.TreeSet;

public class zongrenwushichang16 {

    public static void main(String[] args) {
        int arr0 = 1;
        int arr1 = 2;
        int arr2 = 3;
        System.out.println(getResult(arr0, arr1, arr2));
    }

    private static String getResult(int taskA, int taskB, int num) {
        if (num == 0) return "[]";

        if (taskA == taskB) {
            return Arrays.toString(new int[] {taskA * num});
        }

        TreeSet<Integer> ans = new TreeSet<>();
        for (int i = 0; i <= num; i++) {
            ans.add(taskA * i + taskB * (num - i));
        }
        return ans.toString();
    }
}
