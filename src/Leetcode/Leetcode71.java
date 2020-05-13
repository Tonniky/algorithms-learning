package Leetcode;

import java.util.Stack;

public class Leetcode71 {

    public String simplifyPath(String path) {
        if (path.isEmpty()){
            return null;
        }
        Stack<String> stack = new Stack<>();
        String[] temp = path.split("/");
        for (String str : temp) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals("") && !str.equals(".")) {
                stack.push(str);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }


        public static void main(String[] args) {
        Leetcode71 put = new Leetcode71();
        String input = "/a/./b/../../c/";
        put.simplifyPath(input);
    }

}
