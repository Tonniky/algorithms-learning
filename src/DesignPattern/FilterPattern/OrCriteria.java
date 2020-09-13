package DesignPattern.FilterPattern;

import java.util.List;

public class OrCriteria implements Criteria {
    public Criteria firstCriteria;
    public Criteria otherCriteria;

    public OrCriteria (Criteria firstCriteria, Criteria otherCriteria) {
        this.firstCriteria = firstCriteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPerson = firstCriteria.meetCriteria(persons);
        List<Person> otherCriteriaPerson = otherCriteria.meetCriteria(persons);

        for (Person person : otherCriteriaPerson) {
            if (!firstCriteriaPerson.contains(person)) {
                firstCriteriaPerson.add(person);
            }
        }
        return firstCriteriaPerson;
    }
}
