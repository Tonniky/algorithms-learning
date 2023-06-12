package DesignPattern.createMode.AbstractFactory;

public class ShiftFactory extends AbstractFactory{
    @Override
    public Color getColor(String colorType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Team getTeam(String teamType) {
        if (teamType == null) {
            return null;
        }
        if (teamType.equalsIgnoreCase("Day")) {
            return new Day();
        }
        if (teamType.equalsIgnoreCase("Night")) {
            return new Night();
        }
        return null;
    }
}
