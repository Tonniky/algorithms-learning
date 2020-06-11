package Leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class Leetcode414 {
//    public int thirdMax(int[] nums) {
//        LinkedList<Integer> stack = new LinkedList<>();
//        if(nums == null || nums.length == 0) {
//            return -1;
//        }
//        for(int i = 0; i < nums.length; i++) {
//            while ( !stack.isEmpty() && stack.peek() >)
//        }
//    }

    public int thirdMax(int[] nums) {
        long first=Long.MIN_VALUE,second=Long.MIN_VALUE,third=Long.MIN_VALUE;
        for(long num:nums){
            if(num>first){
                third=second;
                second=first;
                first=num;
            }else if(num>second&&num<first){
                third=second;
                second=num;
            }else if(num>third&&num<second){
                third=num;
            }
        }
        return (third==Long.MIN_VALUE||third==second)?(int)first:(int)third;
    }

    }
