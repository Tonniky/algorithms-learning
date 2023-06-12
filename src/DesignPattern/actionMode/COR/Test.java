package DesignPattern.actionMode.COR;


public class Test {
    public static void main(String[] args) {
        RequestHandle hr = new HRRequestHandle();
        RequestHandle tl = new TLRequestHandle(hr);
        RequestHandle pm = new PMRequestHandle(tl);

        Request request = new Request();
        tl.handleRequest(request);

        System.out.println("======");
        request = new AddMoneyRequest();
        tl.handleRequest(request);

        System.out.println("======");
        request = new DimissionRequest();
        tl.handleRequest(request);

        System.out.println("======");
        request = new LeaveRequst();
        pm.handleRequest(request);
    }
}
