package Aop.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理类，需要实现invoke接口
public class ProxyClass implements InvocationHandler {
    private Object realClass;
    ProxyClass(Object realClass) {
        this.realClass = realClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("before");
        method.invoke(realClass, args);  //被代理的类的方法
        System.out.print("after");
        return null;
    }
}
