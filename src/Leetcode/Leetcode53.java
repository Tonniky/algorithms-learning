package Leetcode;

//import sun.jvm.hotspot.debugger.cdbg.Sym;

public class Leetcode53 {
    public static int MaxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for(int i = 0; i < nums.length; i++){


//        foreach (int x in nums) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(MaxSubArray(nums));
        Leetcode53 leetcode = new Leetcode53();
        int res = leetcode.maxSubArray2(nums);
        System.out.println("分治法的结果为" + res);
    }


    /**
     * 分治法
     *首先最好维护的是 iSum，区间 [l,r] 的 iSum 就等于「左子区间」的 iSum 加上「右子区间」的 iSum。
     *对于 [l,r] 的 lSum，存在两种可能，它要么等于「左子区间」的 lSum，要么等于「左子区间」的 iSum 加「右子区间」的 lSum，二者取大
     *对于 [l,r] 的 rSum，同理，它要么等于「右子区间」的 rSum，要么等于「右子区间」的 iSum 加上「左子区间」的 rSum，二者取大
     * 当计算好上面的三个量之后，就很好计算 [l,r] 的 mSum 了。我们可以考虑 [l,r] 的 mSum 对应的区间是否跨越 m
     * ——它可能不跨越 m，也就是说 [l,r] 的 mSum 可能是「左子区间」的 mSum 和 「右子区间」的 mSum 中的一
     * 个；它也可能跨越m，可能是「左子区间」的 rSum 和 「右子区间」的 lSum 求和。三者取其大。
     */

    public  int maxSubArray2(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public  Status getInfo(int[] a, int l, int r) {
        if (l == r) return new Status(a[l], a[l], a[l], a[l]);
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public class Status {
        public int lSum, rSum, mSum, iSum;
        public Status(int lSum_, int rSum_, int mSum_, int iSum_) {
            lSum = lSum_; rSum = rSum_; mSum = mSum_; iSum = iSum_;
        }
    }

    public  Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    //dp解决：
    public int maxSubArray3(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int tem : nums) {
            if(sum > 0) {
                sum += tem;
            } else {
                sum = tem;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
