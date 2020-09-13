package DesignPattern.InterceptingFilter;

public class DebugFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.printf("debug request" + request);
    }
}
