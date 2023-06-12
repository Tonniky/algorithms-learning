package DesignPattern.createMode.AbstractFactory;

public class ShapeFactory extends AbstractFactory{

    @Override
    public Color getColor(String colorType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("Rectangle")) {
            return (Shape) new Rectangle();
        } else if (shapeType.equalsIgnoreCase("Circle")){
            return (Shape) new Circle();
        }
        return null;
    }

    @Override
    public Team getTeam(String teamType) {
        return null;
    }
}
