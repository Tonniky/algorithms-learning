package Leetcode;

public class Leetcode65 {

    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = false;
        boolean pointAfter = true;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } else if (s.charAt(i) == '.') {
                if (!numberSeen)
                    return false;
                pointSeen = false;
            } else if (s.charAt(i) == 'e') {
                if (!numberSeen)
                    return false;
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = ".1";
        Leetcode65 output = new Leetcode65();
        boolean res = output.isNumber(str);
        System.out.print(res);
    }


}
