package DesignPattern.AbstractFactory;

public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String colorType) {
        if (colorType == null) {
            return null;
        } else if (colorType.equalsIgnoreCase("Red")) {
            return new Red();
        } else if (colorType.equalsIgnoreCase("Green")) {
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String ShapeType) {
        return null;
    }
}
