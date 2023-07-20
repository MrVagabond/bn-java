package mrzj.demo.proxy;


import java.lang.reflect.Proxy;

public class ProxyDemo {

    public static void main(String[] args) {

        EntityHandler handler = new EntityHandler(new EntityImpl());

        Entity entity = (Entity) Proxy.newProxyInstance(
                Entity.class.getClassLoader(), // 类加载器
                new Class[]{Entity.class}, // 需要实现的接口的数组
                handler);
        entity.doSomething();
    }

}
