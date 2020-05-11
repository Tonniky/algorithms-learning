package Leetcode;

public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0 ) {
            return 0;
        }
        s = s.trim();
        if(s.indexOf(" ") == -1) {
            return s.length();
        }
        int res = s.length() - s.lastIndexOf(" ") - 1;
        return res;
    }

    public int lengthOfLastWord2(String s) {
        if(s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int num = 0;
        boolean flag = false;
        for(int i = ch.length - 1; i >= 0; i--){
            if(ch[i] != ' ') {
                num++;
                flag = true;
            }
            if(flag && ch[i] ==' ')
                break;
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "world ";
        Leetcode58 demo = new Leetcode58();
        demo.lengthOfLastWord2(s);
    }
}
