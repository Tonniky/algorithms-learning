package DesignPattern.createMode.Prototype;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype pro = new ConcretePrototype("prototype");
        Prototype pro2 = (Prototype) pro.clone();
        System.out.println(pro.getName());
        System.out.println(pro2.getName());
    }

}
