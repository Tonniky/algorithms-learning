package DesignPattern.FilterPattern;

public class Person {
    public String name;
    public String gender;
    public String martilName;

    public Person(String name, String gender, String martilName) {
        this.name = name;
        this.gender = gender;
        this.martilName = martilName;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMartilName() {
        return martilName;
    }
}
