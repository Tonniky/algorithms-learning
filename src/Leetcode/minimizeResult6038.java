package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class minimizeResult6038 {
    public static String minimizeResult(String expression) {
        String[] index = expression.split("\\+");
        String fs = index[0];
        String ss = index[1];
        int pre = Integer.parseInt(fs);
        int next = Integer.parseInt(ss);
        Map<Integer,Integer> fM = new HashMap<Integer,Integer>();
        Map<Integer,Integer> sM = new HashMap<Integer,Integer>();
        int res = Integer.MAX_VALUE;
        if (pre < 10 && next < 10) {
            int sp = pre * next;
            return "(" + expression + ")";
        }
        int ans = 0;
        int indexF = 0;
        while(pre != 0) {
            int temp = pre % 10;
            pre = pre / 10;
            fM.put(pre, temp * (int)Math.pow(10.0, indexF++) + ans);
            ans = temp * (int)Math.pow(10.0, indexF - 1) + ans;
        }
        int aim = 0;
        int indexS = 0;
        while(next != 0) {
            int temp = next % 10;
            next = next / 10;
            sM.put(next, temp * (int)Math.pow(10.0, indexS++) + aim);
            aim = temp * (int)Math.pow(10.0, indexS - 1) + aim;
        }
        String strTemp = "";
        for(Map.Entry<Integer,Integer> i: fM.entrySet()) {
            for (Map.Entry<Integer,Integer> j: sM.entrySet()) {
                int bigValue = 0;
                if (i.getKey()!= 0 && j.getKey() != 0 ) {
                     bigValue = i.getKey() * (i.getValue() + j.getKey()) * j.getValue();
                } else if (i.getKey() != 0 && j.getKey() == 0){
                     bigValue = i.getKey() * (i.getValue() + j.getValue());
                } else if (i.getKey() == 0 && j.getKey() != 0) {
                    bigValue = (i.getValue() + j.getKey()) * j.getValue();
                } else {
                    bigValue = i.getValue() + j.getValue();
                }
                    if (bigValue < res) {
                        res = bigValue;
                        if (i.getKey() != 0 ) {
                            strTemp = i.getKey() + "(" + i.getValue() + "+";
                        } else {
                            strTemp = "(" + i.getValue() + "+";
                        }
                        if (j.getKey() != 0) {
                            strTemp = strTemp + j.getKey() + ")" + j.getValue();
                        } else {
                            strTemp = strTemp + j.getValue() + ")";
                        }
                    }
            }
        }
        return strTemp;
    }

    public static void main(String[] args) {
        String test = "6+95";
        String res = minimizeResult(test);
        System.out.println(res);
    }
}
