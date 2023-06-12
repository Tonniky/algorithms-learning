package DesignPattern.createMode.Builder;

public class ManBuilder implements PersonBuilder {
    Person person;

    public ManBuilder() {
        person = new Man();
    }

    @Override
    public void buildHead() {
        System.out.println("构造头");
    }

    @Override
    public void buildBody() {
        System.out.println("构造身体");
    }

    @Override
    public void buildFoot() {
        System.out.println("构造脚");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
