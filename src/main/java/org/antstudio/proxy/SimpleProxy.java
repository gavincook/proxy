package org.antstudio.proxy;

import org.antstudio.Animal;
import org.antstudio.Person;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Gavin
 * @date 14-7-27 13:45
 */
public class SimpleProxy implements InvocationHandler{

    private Object target;

    public Animal getProxy(Animal o){
        this.target = o;
        return (Animal)Proxy.newProxyInstance(o.getClass().getClassLoader(), new Class[]{Animal.class}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println("Simple Proxy before method:"+methodName);
        Object result = method.invoke(target,args);
        //这里如果使用proxy来处理方法的调用会抛出异常,因为proxy方法的调用，会触发拦截器，而拦截器又会触发方法调用，产生死循环
        System.out.println("Simple Proxy after method:"+methodName);
        return result;
    }

    public static void main(String[] args) throws IOException {
        Person person = new Person("Gavin");
        Animal proxy = new SimpleProxy().getProxy(person);
        proxy.eat();
        proxy.sleep();

    }
}
