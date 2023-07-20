package mrzj.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EntityHandler implements InvocationHandler {

    private final Object bean;

    public EntityHandler(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Before invoking method " + method.getName());

        method.invoke(this.bean, args);

        System.out.println("After invoking method " + method.getName());

        return null;
    }
}
