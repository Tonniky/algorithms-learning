package DesignPattern.actionMode.COR;


public class TLRequestHandle implements RequestHandle {

    private RequestHandle rh;

    public TLRequestHandle(RequestHandle rh) {
        this.rh = rh;
    }

    @Override
    public void handleRequest(Request request) {
        if (request instanceof LeaveRequst) {
            System.out.println("要请假，请领导批准");
        }
    }
}
