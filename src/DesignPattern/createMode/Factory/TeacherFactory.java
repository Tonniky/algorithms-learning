package DesignPattern.createMode.Factory;

public class TeacherFactory implements IWorkFactory {
    @Override
    public Product getWork() {
        return new TeacherProduct();
    }
}
