package DesignPattern.constructMode.Adapter;

public class Test {
    public static void main(String[] args) {
       Target target = new AdapterS(new Adaptee());
       target.adapterMethod();
       target.adapteeMethod();
    }
}
