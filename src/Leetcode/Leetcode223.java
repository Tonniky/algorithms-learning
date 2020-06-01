package Leetcode;

public class Leetcode223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int P = Math.max(A,E), Q = Math.max(B, F), X = Math.min(C, G), Y = Math.min(D, H);
        int area = (C - A) * (D - B);
        if (X > P  && Y > Q)
            area -= (X - P) * (Y - Q);
        return area + (G - E) * (H - F);
    }
    }
