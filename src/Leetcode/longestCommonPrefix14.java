package Leetcode;

public class longestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String str =strs[0];
        for(int i= 0 ;i<strs.length;i++){
            while(strs[i].indexOf(str)!=0){
                str=str.substring(0,str.length()-1);
            }
        }
        return str;
    }
}
