package DesignPattern.createMode.Builder;

public class PersonDirector {

    public Person constructPerson(PersonBuilder pb) {
        pb.buildBody();
        pb.buildFoot();
        pb.buildHead();
        return pb.buildPerson();
    }
}
