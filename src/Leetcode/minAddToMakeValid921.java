package Leetcode;

public class minAddToMakeValid921 {
    //
    public int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }

//    public int minAddToMakeValid1(String S) {
//        int ans = 0, bal = 0;
//        for (int i = 0; i <)
//    }




        public static void main(String[] args) {
        minAddToMakeValid921 minAddToMakeValid921 = new minAddToMakeValid921();
        minAddToMakeValid921.minAddToMakeValid("()))");
    }
}
