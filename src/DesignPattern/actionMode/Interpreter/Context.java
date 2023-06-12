package DesignPattern.actionMode.Interpreter;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private String Content;

    private List<Expression> list = new ArrayList<Expression>();

    public void setContent(String content) {
        Content = content;
    }

    public String getContent() {
        return Content;
    }

    public void add(Expression eps) {
        list.add(eps);
    }

    public List<Expression> getList() {
        return list;
    }
}
