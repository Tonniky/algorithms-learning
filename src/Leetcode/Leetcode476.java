package Leetcode;

public class Leetcode476 {
    public int findComplement(int num) {
        int pos = 0;
        while(num!= 0) {
            num = num / 2;
            pos++;
        }
        int res = (int)Math.pow(2, pos) - 1 - num;
        return res;
    }

    public int findComplement1(int num) {
        int oneNum = ~num;
        int oneBitFlag = 0x80000000;
        while((oneNum & oneBitFlag) != 0) {
            oneNum &= ~oneBitFlag;
            oneBitFlag >>= 1;
        }
        return oneNum;
    }


    public int findComplement2(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder binaryReverse = new StringBuilder();
        for(int i = 0; i < binary.length(); i++)
        {
            if(binary.charAt(i) == '0')
            {
                binaryReverse.append('1');
            }
            else
            {
                binaryReverse.append('0');
            }
        }
        return Integer.parseInt(binaryReverse.toString(), 2);
    }


    public static void main(String[] args) {
        Leetcode476 out =  new Leetcode476();
        out.findComplement2(5);
    }


    }
