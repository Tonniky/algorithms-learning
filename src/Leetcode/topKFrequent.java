package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class topKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res=new ArrayList<>();
//      先用hashmap统计词频
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
//            if(map.containsKey(nums[i])) {
//                map.put(nums[i],map.get(nums[i])+1);
//            }
//            else {
//                map.put(nums[i],1);
//            }
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        int[] nums2=new int[map.size()];
        int index=0;
        for(Integer key:map.keySet()){
            nums2[index++]=map.get(key);
        }
        //        对map中的词频提取前K
//         方法一：快排
        findK(nums2,0,nums2.length-1,nums2.length-k);
//         找到词频对应的数(方法一)
        for(int i=nums2.length-1;i>=nums2.length-k;i--){
//          map.keySet():返回set类型 map.values():collection类型
            for(Integer key:map.keySet()){
                if(map.get(key)==nums2[i]) {
                    if(res.size()==k) return res;
                    res.add(key);
//                   去重
                    map.put(key,0);
                }
            }
        }
        return res;
    }
    // 方法一：快排 找到index为k的划分 复杂度：O(n)
    public void findK(int[] nums,int left,int right,int k) {
        int partion=nums[left];
        int i=left,j=right;
        while(i<j){
            if(nums[j]>=partion) j--;
            else {
                nums[i] = nums[j];
                nums[j] = partion;
                while(i<j) {
                    if(nums[i]<=partion) i++;
                    else {
                        nums[j] = nums[i];
                        nums[i] = partion;
                        break;
                    }
                }
            }
        }
        //         递归
        if(i==k) return;
        //         左边递归
        if(i>k) findK(nums,left,i-1,k);
        //         右边递归
        if(i<k) findK(nums,i+1,right,k);
    }

 /**
  * 敲黑板！！！对于海量数据处理时，堆排序是最佳方案
  *
  * 前K大，维护最小堆；前K小，维护最大堆
  *
  * 1.初始化一个最小堆
  *
  * 2.输入新数据，若大于堆顶则替换堆顶，调整堆为最小堆（从最后一个父节点开始调整）
  *
  * 3.遍历完数据，遍历完数据，堆中数据即为所求
  * */


    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> res=new ArrayList<>();
//      先用hashmap统计词频
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] nums2=new int[map.size()];
        int index=0;
        //
        for(Integer key:map.keySet()){
            nums2[index++]=map.get(key);
        }
//         对map中的词频提取前K
//         方法二：堆排序
        int []top=topK(nums2,k);
//         找到词频对应的数(方法二)
        for(int i=0;i<k;i++){
//            map.keySet():返回set类型 map.values():collection类型
            for(Integer key:map.keySet()){
                if(map.get(key)==top[i]) {
                    if(res.size()==k) return res;
                    res.add(key);
//                    去重   map更新值：put方法覆盖原先数据
                    map.put(key,0);
                }
            }
        }
        return res;
    }


    //    查找topK
    public int[] topK(int[] nums,int k) {
        int top[]=new int[k];
        for(int i=0;i<k;i++) top[i]=nums[i];
//        初始化堆
        buildHeap(top);
//        输入数据，更新堆
        for(int j=k;j<nums.length;j++){
            if(nums[j]>top[0]){
                top[0]=nums[j];
                adjust(top,k,0);
            }
        }
        return top;
    }

    //建堆
    public void buildHeap(int[] nums){
        int length=nums.length;
//        从length/2-1开始调整
        for(int i=length/2-1;i>=0;i--){
            adjust(nums,length,i);
        }
    }


    //     方法二：堆排序
    //    调整堆 递归过程
    public void adjust(int nums[],int size,int index){
//        调整规则：比较父节点和子节点(left,right)
        int left=2*index+1;
        int right=2*index+2;
//       index为调整前父节点
        int min=index;
        if(left<size && nums[left]<nums[min]) min=left;
        if(right<size && nums[right]<nums[min]) min=right;
//       交换位置
        if(min!=index){
            int temp=nums[min];
            nums[min]=nums[index];
            nums[index]=temp;
//递归调整堆
            adjust(nums,size,min);
        }
    }




}
