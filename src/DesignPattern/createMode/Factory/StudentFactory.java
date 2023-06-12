package DesignPattern.createMode.Factory;

public class StudentFactory implements IWorkFactory {
    @Override
    public Product getWork() {
        return new StudentProduct();
    }

}
