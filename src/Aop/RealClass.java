package Aop;

public class RealClass implements RealInterface { //要被代理的真实类
   public RealClass() {}

    @Override
    public void request() {
        System.out.print("realClass request");
    }
}
