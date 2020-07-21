package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum40 {
    List<List<Integer>> list =new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(target==0){return list;} //为0直接返回空集合
        Arrays.sort(candidates);//排序，以便于回溯时候判断是否使用过该头节点
        backtrack(candidates,0,target,new ArrayList<Integer>());
        return list;
    }
    public void  backtrack(int[] nums, int index, int sum, ArrayList<Integer> temp){
        if (sum == 0) {
            // System.out.println(temp);
            list.add(new ArrayList(temp));
            return ;
        }//集合当中的数字满足条件则添加
        if (sum > 0) {
            for (int i=index;i<nums.length;i++) {
                //在一个头节点所有组合寻找完之后才会出现i>index
                //这时如果下一个头节点跟上一个一样，就没必要重复找了
                //避免重复
                if(i > index&&nums[i] == nums[i-1]) {continue;}
                temp.add(nums[i]);
                backtrack(nums,i+1,sum-nums[i],temp);
                //撤销
                temp.remove(temp.size()-1);

            }

        }

    }

}
