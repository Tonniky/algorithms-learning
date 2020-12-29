package group_interview.bigo;

import java.util.*;

public class StringToDouble {
    public double insett(String str) {
        if (str == null || str.length() == 0) {
            return 1.1;
        }
        int len = str.length();
        char[] ch = str.toCharArray();
        int start = 0;
        for(int i = 0; i < len; i++) {
            if (isMath(ch[i])) {
                ch[start++] = ch[i];
            }
        }
        return isValidMath(s);
    }

    public boolean isMath(char ch) {
        if (ch == '.') {
            return true;
        }
        int c = ch - '0';
        if (0 > c && 9 > c) {
            return true;
        }
        return false;
    }

    public double isValidMath(String str) {
        if (isNumeric(str)) {
            return new Exception();
        }
        return Double.parseDouble(str);
    }

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }





    public List<Integer> getResults (int[] arr) {
        if (arr == null || arr.length < 2) {
            return new Expression();
        }

        Map<Integer, Integer> map =  new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++)  {
                int temp = Math.abs(arr[j] - arr[i]);
                map.put(temp, map.getOrDefault(temp,0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (integer arr : map.keySet()) {
            if (map.get(arr) > max) {
                max = map.get(arr);
            }
            if (map.get(arr) < max) {
                min = map.get(arr);
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(max);
        res.add(min);

        retrun res;
    }
}
