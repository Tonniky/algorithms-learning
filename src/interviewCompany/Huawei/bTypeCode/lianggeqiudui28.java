package interviewCompany.Huawei.bTypeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lianggeqiudui28 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        dfs(arr, 0, 0, 0, res);

        int sum = Arrays.stream(arr).reduce(Integer::sum).orElse(0);
        int m = res.stream().map(subSum -> Math.abs(sum - 2 * subSum)).min((a, b) -> a - b).orElse(0);
        System.out.println(m);
    }

    private static void dfs(int[] arr, int index, int level, int sum, ArrayList<Integer> res) {
        if (level == 5) {
            res.add(sum);
            return;
        }

        for (int i = index; i < 10; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            dfs(arr, i + 1, level + 1, sum + arr[i], res);
        }
    }
}
