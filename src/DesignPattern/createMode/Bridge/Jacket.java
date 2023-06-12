package DesignPattern.createMode.Bridge;

public class Jacket extends Clothing{
    @Override
    public void personDressClothing(Person person) {
        System.out.println(person.getType() + "穿马甲");
    }
}
