package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if ( n < 1) {
            return new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                res.add("FizzBuzz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
                continue;
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
    }
