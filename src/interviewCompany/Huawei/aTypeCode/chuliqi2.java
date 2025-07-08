//package interviewCompany.Huawei.aTypeCode;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class chuliqi2 {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        Integer[] arr = Arrays.stream(in.nextLine().split("[\\[\\]\\, \\s]")).filter(str -> !"".equals(str))
//                .map(Integer::parseInt).toArray(Integer[]::new);
//        String num = in.next();
//        System.out.println();
//    }
//
//    private static String getResult(Integer[] arr, String num) {
//        ArrayList<Integer> link1 = new ArrayList<>();
//        ArrayList<Integer> link2 = new ArrayList<>();
//
//        Arrays.sort(arr, (a, b) -> a - b);
//        for (Integer e: arr) {
//            if (e < 4) {
//                link1.add(e);
//            } else {
//                link2.add(e);
//            }
//        }
//
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        int len1 = link1.size();
//        int len2 = link2.size();
//
//        switch (num) {
//            case "1":
//                if (len1 == 1 || len2 == 1) {
//                    if (len1 == 1) dfs(link1, 0, 1, new ArrayList<>(), ans);
//                    if (len2 == 1) dfs(link2, 0, 1, new ArrayList<>(), ans);
//                } else if (len1 == 3 || len2 == 3) {
//                    if (len == 1 )
//                }
//        }
//
//    }
//
//
//    private
//}
