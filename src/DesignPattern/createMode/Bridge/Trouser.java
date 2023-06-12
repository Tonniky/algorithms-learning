package DesignPattern.createMode.Bridge;

public class Trouser extends Clothing {
    @Override
    public void personDressClothing(Person person) {
        System.out.println(person.getType() + "穿裤子");
    }
}
