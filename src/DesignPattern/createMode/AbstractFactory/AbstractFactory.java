package DesignPattern.createMode.AbstractFactory;

public abstract class AbstractFactory {
    public abstract Color getColor(String colorType);
    public abstract Shape getShape(String shapeType);
    public abstract Team  getTeam(String teamType);
}
