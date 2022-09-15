package Leetcode;

public class minInsertions1541 {

    //
    public int minInsertions(String s) {
        int insertions = 0;
        int leftCount = 0; // 左括号的个数
        int length = s.length();
        int index = 0;
        while (index < length) {  //
            char c = s.charAt(index);
            if (c == '(') {
                leftCount++;
                index++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    insertions++;
                }
                if (index < length - 1 && s.charAt(index + 1) == ')') {
                    index += 2;
                } else {
                    insertions++;
                    index++;
                }
            }
        }
        insertions += leftCount * 2;
        return insertions;
    }

    public int minInsertions2(String s) {
        int insertion = 0;
        int leftCount = 0;
        int index = 0;
        int len = s.length();
        while(index < len) {
            if (s.charAt(index) == '(') {
                index++;
                leftCount++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    insertion++;
                }
                //
                if (index < len - 1 && s.charAt(index + 1) == ')') {
                    index += 2;
                } else {
                    insertion++;
                    index++;
                }
            }
        }
        insertion += leftCount * 2;
        return insertion;
    }



    }
