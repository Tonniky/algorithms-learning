package Leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class zigzagLevelOrder103 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }

    Deque<TreeNode> deque = new ArrayDeque<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
               TreeNode treeNode =  deque.removeFirst();
               temp.add(treeNode.val);
               if (treeNode.left != null) {
                   deque.add(treeNode.left);
               }
               if (treeNode.right != null) {
                   deque.add(treeNode.right);
               }
            }
            res.add(temp);
        }
        return res;
    }



    public static void main(String[] args) throws ParseException {
        compareOutTime();
//        String time = convertTime("637595729210000000");
//        System.out.println(time);
    }

    public static String convertTime(String time) throws ParseException {
        long i = 0;
        String baseTime = "630822816000000000";
        Long res = Long.parseLong(time) -Long.parseLong(baseTime);
        if (res < 0) {
            i = 8 * 3600;
        } else {
            i =  res / 10000000 + 8 * 3600;
        }
//        Date df= DateFormat.getDateTimeInstance().parse("2000-01-01 00:00:00");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
        String ddd= "2000-01-01 00:00:00";
        Date parseTime = new Date(sdf.parse(ddd).getTime() + i * 1000);
        String result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parseTime);
        String te = "0";
        return result;
    }


    public static boolean compareOutTime() throws ParseException {
        String planTime, actTime, thresHold;
        planTime = "2021-07-23 08:30";
        actTime = "2000-01-01 02:59:30";
        thresHold = "3";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



        long timecurrentTimeMillis = System.currentTimeMillis();
        String timeLong = "2021-07-29 10:30:30";

        long checkTime1 = Long.parseLong(thresHold) * 60 * 60 * 1000 - (timecurrentTimeMillis - sdf.parse(timeLong).getTime()) ;


//        long checkTime = Long.parseLong(thresHold) * 60 * 60 * 1000 - (sdf.parse(actTime).getTime() - sdf.parse(planTime).getTime()) ;
//        if (checkTime >= 0) {
//            return true;
//        }

        String test = "zf01 is test for string";
        System.out.println(test.indexOf("This")); //0
        System.out.println(test.indexOf("is")); //2
        System.out.println(test.indexOf("test")); //8
        System.out.println(test.indexOf("for")); //13
        System.out.println(test.indexOf("for string       "));//-1
        if (test.indexOf("zf01")!=-1)
            System.out.println("存在包含关系，因为返回的值不等于-1");

            return false;
    }






}
