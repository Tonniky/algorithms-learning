package Leetcode;

import java.util.Arrays;

public class threeSumClosest15 {
    public int threeSumClosest(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        int closeNum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r= nums.length-1;
            while(l<r){
                int threeSum = nums[i]+nums[l]+nums[r];
                if(((closeNum-target)>0?(closeNum-target):(target-closeNum))>((target-threeSum>0)?(target-threeSum):(threeSum-target))){
                    closeNum = threeSum;
                }
                if(threeSum>target){
                    r--;
                }else if(threeSum<target){
                    l++;
                }else{
                    return target;
                }
            }
        }
        return closeNum;
    }
}
