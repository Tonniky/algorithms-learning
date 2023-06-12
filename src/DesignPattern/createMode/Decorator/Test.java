package DesignPattern.createMode.Decorator;

public class Test {
    public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA manDecoratorA = new ManDecoratorA();
        manDecoratorA.eat();
        manDecoratorA.setPerson(man);

    }
}
