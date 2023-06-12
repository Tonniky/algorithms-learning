package DesignPattern.createMode.Factory;

public class StudentProduct implements Product {

    @Override
    public void work() {
        System.out.println("学生工作");
    }
}
