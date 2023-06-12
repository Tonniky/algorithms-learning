package DesignPattern.actionMode.COR;



public class HRRequestHandle implements RequestHandle{
    @Override
    public void handleRequest(Request request) {
        if (request instanceof DimissionRequest) {
            System.out.println("要离开，人事请批准");
        }
        System.out.println("请求完毕");
    }
}
