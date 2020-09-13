package DesignPattern.InterceptingFilter;

public class Target {
    public void execute(String request) {
        System.out.printf("executing request" + request);
    }
}
