package DesignPattern.createMode.Factory;

public class TeacherProduct implements Product {
    @Override
    public void work() {
        System.out.println("学生工作");
    }
}
