package Stream;

/**
 * Created by Administrator on 2019/5/31.
 */
public class Person {
    public Person(int id, String name, int age){
        this.setPersonID(id);
        this.setName(name);
        this.setAge(age);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    private int personID;
}
