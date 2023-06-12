package DesignPattern.createMode.Decorator;

// Decorator 维持一个指向Component对象的指针，并定义一个与Component接口一致的接口。
public class Decorator implements Person{

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }


    @Override
    public void eat() {
        person.eat();
    }
}
