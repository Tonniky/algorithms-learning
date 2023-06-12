package DesignPattern.createMode.Bridge;

public class Lady extends Person{

    public Lady() {
        setType("女人");
    }


    @Override
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressClothing(this);
    }
}

