package Aop.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Solution {
    public static void main(String[] args) {
        RealClass realClass = new RealClass();
        InvocationHandler h = new ProxyClass(realClass);
        RealInterface r = (RealInterface) Proxy.newProxyInstance(realClass.getClass().getClassLoader(),
                realClass.getClass().getInterfaces(), h);
        r.request();
    }
}
