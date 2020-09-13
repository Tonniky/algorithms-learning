package DesignPattern.ChainResponsibility;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.printf("ErrorLogger ::write" + message);
    }
}
