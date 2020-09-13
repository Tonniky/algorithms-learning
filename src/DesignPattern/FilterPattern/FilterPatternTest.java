package DesignPattern.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class FilterPatternTest {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));

        Criteria single = new CriteriaFemale();
        Criteria female = new CriteriaFemale();
        Criteria male =  new CriteriaMale();
        Criteria singlemale = new AndCriteria(single,male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        single.meetCriteria(persons);

        singlemale.meetCriteria(persons);

        singleOrFemale.meetCriteria(persons);
    }


}
