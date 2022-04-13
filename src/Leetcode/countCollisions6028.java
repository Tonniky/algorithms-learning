package Leetcode;

public class countCollisions6028 {
    public static int countCollisions(String directions) {
        char[] ch = directions.toCharArray();
        int len = ch.length;
        int sum = 0;
        boolean peek = false;
        int rigthtNum = 0;
        for (int i = 1; i < len; i++) {
            if (ch[i] == 'L') {
                if (ch[i - 1] == 'R') {
                    sum += 2;
                    peek = true;
                } else if (ch[i - 1] == 'S' || peek == true ) {
                    sum++;
                }
            } else if (ch[i] == 'S' ){
                if (ch[i - 1] == 'R') {
                    sum++;
                    peek = true;
                } else if (rigthtNum != 0) {
                    sum += rigthtNum;
                    rigthtNum = 0;
                    peek = true;
                }

            } else if (ch[i] == 'R') {
                rigthtNum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
        int res = countCollisions(s);
        System.out.println(res);
    }
}
