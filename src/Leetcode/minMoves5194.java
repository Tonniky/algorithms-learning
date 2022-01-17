package Leetcode;

public class minMoves5194 {
    public int minMoves(int target, int maxDoubles) {
        boolean temp = true;
        int res = 0;
        while (target != 0) {
            temp = target % 2 == 0 ? true : false;
            if (temp && maxDoubles > 0) {
                target /= 2;
                maxDoubles--;
                res++;
            } else {
                target -= 1;
                res++;
            }
            if (target == 1) {
                return res;
            }
        }
        return res;
    }
}
