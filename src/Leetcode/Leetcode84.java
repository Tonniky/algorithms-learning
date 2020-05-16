package Leetcode;

public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        int Max = 0;
        for (int i = 0; i < heights.length; i++){
            for(int j = i; j< heights.length; j++) {
               int  MinHeight = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++) {
                    MinHeight = Math.min(MinHeight,heights[k]);
                }
                Max = Math.max(Max,(j - i + 1) * MinHeight);
            }
        }
        return Max;
    }

    public int largestRectangleArea1(int[] heights) {
        int Max = 0;
        for (int i = 0; i < heights.length; i++){
            int  MinHeight = Integer.MAX_VALUE;
            for(int j = i; j< heights.length; j++) {
                MinHeight = Math.min(MinHeight,heights[j]);
                Max = Math.max(Max,(j - i + 1) * MinHeight);
            }
        }
        return Max;
    }

    public int largestRectangleArea2(int[] heights) {
        return  calcul(heights, 0, heights.length - 1);
    }

    public int calcul(int[] heights,int start, int end) {
        if(start > end)
            return 0;
        int minIndex = start;
        for(int i = minIndex; i < end; i++) {
            if(heights[minIndex] > heights[i]) {
                minIndex = i;
            }
        }
        return Math.max(calcul(heights,start,minIndex - 1), Math.max(heights[minIndex] * (end - start + 1), calcul(
                heights,minIndex + 1, end)));
    }

    //堆栈结构去优化
    public int largestRectangleArea3(int[] heights) {
        return 1;
    }




        public static void main(String[] args) {
        Leetcode84 input = new Leetcode84();
        int[] res = {2,1,5,6,2,3};
        input.largestRectangleArea1(res);
    }


    }
