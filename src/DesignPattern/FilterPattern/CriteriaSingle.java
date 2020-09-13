package DesignPattern.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePerson = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("single")) {
                singlePerson.add(person);
            }
        }
        return singlePerson;
    }

}
