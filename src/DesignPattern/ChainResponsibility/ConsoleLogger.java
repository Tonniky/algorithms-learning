package DesignPattern.ChainResponsibility;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger (int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.printf("Standard Console ::write" + message);
    }
}
