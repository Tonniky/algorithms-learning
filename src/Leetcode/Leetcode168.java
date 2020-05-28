package Leetcode;

public class Leetcode168 {
   public String convertToTitle(int n) {
        String ans = new String();
        int tmp;
        while(n !=0){
            n=n-1;
            tmp=n%26;
            ans+=(char)(tmp+'A');
            n/=26;
        }
        return new StringBuilder(ans).reverse().toString();
    }
    
    public String convertToTitle1(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if(c == 0){
                c = 26;
                n -= 1;
            }
            sb.insert(0, (char) ('A' + c - 1));
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 27;
        Leetcode168 out = new Leetcode168();
        out.convertToTitle(28);
    }

}
