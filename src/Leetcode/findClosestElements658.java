//package Leetcode;
//
//public class findClosestElements658 {
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int min = arr[0], max = arr[arr.length -1];
//        int[] res = new int[k];
//        if(x <= min) {
//            for (int i = 0; i < k; i++) {
//                res[i] = arr[i];
//            }
//        } else if (x >= max) {
//            int j = 0;
//            for (int i = arr.length - k; i < arr.length; i++) {
//                res[j++] = arr[i];
//            }
//        } else {
//            int[] link = new int[arr.length -1];
//            int index = 0;
//            for (int i = 0; i < len; i++) {
//                link[i] = Math.abs(arr[i] - x);
//                if (link[i] < link[index]) {
//                    index = link;
//                }
//            }
//
//        }
//    }
//}
