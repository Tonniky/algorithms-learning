package Leetcode;

public class findLengthOfShortestSubarray1574 {


    public static void main(String[] args) {
        findLengthOfShortestSubarray1574 findLengthOfShortestSubarray1574 = new findLengthOfShortestSubarray1574();
        findLengthOfShortestSubarray1574.findLengthOfShortestSubarray3(new int[]{1});
    }

    public int findLengthOfShortestSubarray4(int[] arr) {
        //寻找左区间右端点.
        int leftEnd = 0;
        for(; leftEnd<arr.length - 1; leftEnd++) {
            if(arr[leftEnd]>arr[leftEnd+1]) break;
        }
        //寻找右区间左端点.
        int rightStart = arr.length - 1;
        for(;rightStart>0;rightStart--) {
            if(arr[rightStart] < arr[rightStart-1]) break;
        }
        //排出中间没有删除的情况
        if(leftEnd >= rightStart) return 0;
        //min用来表示最短的删除,用没有左区间初始化。
        int min = rightStart;
        for(int i = 0;i <= leftEnd;i++) {
            int left = rightStart;
            //这里需要取空，应为可能没有右区间
            int right = arr.length;
            while(left < right) {
                int mid = (left+right)/2; //
                if(arr[mid] >= arr[i]) right = mid;
                else left = mid+1;
            }
            min = Math.min(min,right - i - 1);
        }
        return min;
    }


    public int findLengthOfShortestSubarray3(int[] arr) {
        int leftEnd = 0;
        for (; leftEnd < arr.length - 1; leftEnd++) {
            if (arr[leftEnd] > arr[leftEnd + 1])
                break;
        }
        int rightStart = arr.length - 1;
        for ( ;rightStart > 0; rightStart--) {
            if (arr[rightStart] < arr[rightStart - 1] )
                break;
        }
        if (leftEnd > rightStart) return 0;
        int min = rightStart;
        for (int i = 0; i <= leftEnd; i++) {
            int left = rightStart;
            int right = arr.length;
            while(left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] >= arr[i]) right = mid;
                else
                    left = mid + 1;
            }
            min = Math.min(min, right - i - 1);
        }
        return min;
    }


        //
    public int findLengthOfShortestSubarray1(int[] arr) {
        int l  = 0, r = arr.length-1;
        for(int i = 1; i < arr.length; ++i){
            if(arr[i]>=arr[i-1]) l=i;
            else break;
        }
        for(int i = arr.length-2; i >= 0; --i){
            if(arr[i]<=arr[i+1]) r=i;
            else break;
        }
        if(l>=r) return 0;
        int res = Math.min(arr.length-(l+1),r); //
        for(int i = 0; i <= l; ++i){ //
            int s = r,e = arr.length;
            while(s<e){
                int mid = s+e>>1;
                if(arr[mid]>=arr[i]) e = mid;
                else s = mid+1;
            }
            res = Math.min(res,s-i-1);
        }
        return res;
    }


}