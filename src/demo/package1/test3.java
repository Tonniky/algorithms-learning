package demo.package1;

/** * 注意点:
 * 1.抽象类不一定有抽象方法,但是有抽象方法的一定是抽象类.
 * 2.继承了抽象类的子类一定要实现抽象方法,如果不实现就只能将自己也变成抽象的.
 * 3.抽象类不能直接创建对象,必须通过子类实现,所以抽象类一定有子类
 * */
public abstract class test3 {
    public abstract void sub();
    public static int sht;
}
