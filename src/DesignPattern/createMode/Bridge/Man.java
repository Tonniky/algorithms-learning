package DesignPattern.createMode.Bridge;


public class Man extends Person {

    public Man() {
        setType("男人");
    }

    @Override
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressClothing(this);
    }
}
