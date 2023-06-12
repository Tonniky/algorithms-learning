package DesignPattern.createMode.Factory;

public class WorkTest {
    public static void main(String[] args) {
        IWorkFactory studentWorkFactory = new StudentFactory();
        studentWorkFactory.getWork().work();

        IWorkFactory teacherWorkFactory = new TeacherFactory();
        teacherWorkFactory.getWork().work();

    }

}
