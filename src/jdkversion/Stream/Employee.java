package jdkversion.Stream;

/**
 * Created by Administrator on 2019/5/31.
 */
public class Employee {
    private String job;
    private double salary;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    private int personID;
    public Employee(int id, String job, double salary){
        this.setJob(job);
        this.setPersonID(id);
        this.setSalary(salary);
    }
}
