package Leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int num = 0;
        int bg = 0;
        for (int i = 0; i < words.length; i++) {
            num += words[i].length() + 1;
            if(i + 1 == words.length || num + words[i + 1].length() > maxWidth) {
                boolean isLastLine = i + 1 == words.length;
                res.add(fillwords(words, bg, i, maxWidth, isLastLine));
                bg = i + 1;
                num = 0;
            }
        }
        return res;
    }

    public String fillwords(String[] words, int begin, int end, int maxWidth, boolean flag) {
        int wordCount = end - begin + 1;
        int spaceCount = maxWidth + 1 - wordCount;
        for (int i = begin; i <= end; i++) {
            spaceCount -= words[i].toString().length();
        }
        int spaceSuffix = 1; //至少保证一个空格
        int spaceAvg = (wordCount == 1 || flag) ? 0 : spaceCount / (wordCount - 1); //平均空格
        if (flag) {
           spaceAvg = 0;
        }
        int spaceExtra = (wordCount == 1 || flag) ? 0 : spaceCount % (wordCount - 1); //
        StringBuilder temp = new StringBuilder();
        if (wordCount == 1) {
            int afterCount = maxWidth - words[begin].length() - 1;
            temp.append(words[begin]);
            for(int i = 1; i <= (spaceSuffix + spaceAvg + afterCount); i++) {
                temp.append(" ");
            }
        } else{
            for(int i = begin; i < end; i++) {
                temp.append(words[i]);
                temp.append(putSpace(spaceSuffix + spaceAvg));
                if(spaceExtra != 0) {
                    temp.append(" ");
                    spaceExtra--;
                }
            }
            temp.append(words[end]);
            if (flag) {
                int lastSpace = spaceCount;
                temp.append(putSpace(lastSpace));
            }
        }
        return temp.toString();

    }

    public String putSpace(int n) {
        StringBuilder str = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            str.append(" ");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Leetcode68 result = new Leetcode68();
        String[] input = {"What","must","be","acknowledgment","shall","be"};
        result.fullJustify(input, 16);
    }


    }







