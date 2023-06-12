package DesignPattern.constructMode.Adapter;

public class AdapterS implements Target{

    private Adaptee adaptee;

    public AdapterS(Adaptee ad) {
        this.adaptee = ad;
    }

    @Override
    public void adapteeMethod() {
        adaptee.adapteeMethod();
    }

    @Override
    public void adapterMethod() {
        System.out.println("AdapterMethod");
    }
}
