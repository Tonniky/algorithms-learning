package DesignPattern.createMode.Decorator;

// 给组件添加职责
public class ManDecoratorA extends Decorator{

    @Override
    public void eat() {
        super.eat();
        reeat();
    }


    public void reeat() {
        System.out.println("再吃一顿");
    }
}
