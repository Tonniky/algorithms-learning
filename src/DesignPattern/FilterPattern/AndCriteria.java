package DesignPattern.FilterPattern;

import java.util.List;

public class AndCriteria implements Criteria {
    public Criteria criteria;
    public Criteria otherCriteria;

    public AndCriteria(Criteria circle, Criteria otherCriteria) {
        this.criteria = circle;
        this.otherCriteria = otherCriteria;
    }



    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPerson = criteria.meetCriteria(persons);
        List<Person> otherCriteriaPerson = otherCriteria.meetCriteria(firstCriteriaPerson);
        return otherCriteriaPerson;
    }

}
