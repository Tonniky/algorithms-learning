package DesignPattern.createMode.Decorator;

// Component 定义一个对象接口，可以给这些对象动态地添加职责。
public class Man implements Person{
    @Override
    public void eat() {
        System.out.println("男人吃");
    }
}
