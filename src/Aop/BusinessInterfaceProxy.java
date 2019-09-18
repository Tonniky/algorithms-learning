package Aop;

import java.lang.reflect.Method;

/**
 * @author litao
 */
public class BusinessInterfaceProxy {

    private Object target;

//    public Object getInstance(Object target) {
//
//        this.target = target;
//        Enhancer enhancer = new Enhancer();
//
//        enhancer.setSuperclass(this.target.getClass());
//        enhancer.setCallback(this);
//
//        return enhancer.create();
//    }
//
//    @Override
//    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//
//        System.out.println("事物开始...");
//        proxy.invokeSuper(obj, args);
//        System.out.println("事物结束...");
//        return null;
//    }


}

