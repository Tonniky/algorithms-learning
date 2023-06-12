package DesignPattern.actionMode.COR;


public class PMRequestHandle implements RequestHandle{
    RequestHandle rh;

    public PMRequestHandle(RequestHandle rh) {
        this.rh = rh;
    }

    @Override
    public void handleRequest(Request request) {
        if (request instanceof AddMoneyRequest) {
            System.out.println("要加薪，项目经理批准");
        } else {
            rh.handleRequest(request);
        }
    }



}
