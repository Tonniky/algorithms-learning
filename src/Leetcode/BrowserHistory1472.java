package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory1472 {
    class BrowserHistory {
        int len;
        int idx;
        List<String> memo;  // 动态数组

        // 历史记录
        public BrowserHistory(String homepage) {
            this.memo = new ArrayList<>();
            this.idx  = 1;
            this.len  = 1;
            this.memo.add(null);    // 塞入一个空, 这样可以让 idx == len
            this.memo.add(homepage);// 第一个
        }

        // 访问新的, 这里涉及到退回后访问, 此时有后续都没有了, 所以 this.len = this.idx;
        public void visit(String url) {
            this.memo.add(++this.idx, url);
            this.len = this.idx;
        }

        public String back(int steps) {
            if(steps >= this.idx){  // 退回长度 >= 总数, 则只能退回到 根目录
                this.idx = 1;
                return this.memo.get(1);
            }
            this.idx -= steps;
            String urlStr = this.memo.get(this.idx);
            return urlStr;
        }

        public String forward(int steps) {
            if(steps > this.len - this.idx){    // 只能访问到最后访问的
                this.idx = this.len;
                return this.memo.get(this.idx);
            }
            this.idx += steps;
            String urlStr = this.memo.get(this.idx);
            return urlStr;
        }
    }

}
