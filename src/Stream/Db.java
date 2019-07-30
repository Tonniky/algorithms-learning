package Stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/5/31.
 */
public class Db {
    List<Person> getPerson(){
        return Arrays.asList(new Person(1,"xiaoming", 25), new Person(2,"zhangsan", 24), new Person(3,"wangwu", 22), new Person(4,"xiaofang", 66));
    }
    List<Employee> getEmployee(){
        System.out.println("get called");
        return Arrays.asList(new Employee(1, "designer", 10000), new Employee(3, "coder", 12000), new Employee(2, "coder", 13000), new Employee(5, "tester", 9000));
    }
}
