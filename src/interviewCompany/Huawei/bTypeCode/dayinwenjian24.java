package interviewCompany.Huawei.bTypeCode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dayinwenjian24 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[][] tasks = new String[n][];

        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(" ");
            tasks[i] = s;
        }

        getResult(tasks);

    }

    private static void getResult(String[][] tasks) {
        HashMap<String, PriorityQueue<int[]>> print = new HashMap<>();

        int x = 1;
        for (int i = 0; i < tasks.length; i++) {
            String[] task = tasks[i];

            String type = task[0];
            String printId = task[1];

            if ("IN".equals(type)) {
                String priority = task[2];

                int[] arr = {x, Integer.parseInt(priority), i};
                print.putIfAbsent(printId, new PriorityQueue<>((a, b) -> a[1] != b[1] ?
                        b[1] - a[1] : a[2] - b[2]));

                print.get(printId).offer(arr);
            } else {
                if (!print.containsKey(printId) || print.get(printId).isEmpty()) {
                    System.out.println("NULL");
                } else {
                    int[] arr = print.get(printId).poll();
                    if (arr != null) System.out.println(arr[0]);
                    else System.out.println("NULL");
                }
            }
        }
    }
}
