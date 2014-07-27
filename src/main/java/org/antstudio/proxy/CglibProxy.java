package org.antstudio.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.antstudio.Person;

/**
 * @author Gavin
 * @date 14-7-27 下午5:05
 */
public class CglibProxy {

    private MethodInterceptor methodInterceptor;

    public CglibProxy(MethodInterceptor methodInterceptor){
        this.methodInterceptor = methodInterceptor;
    }

    public <T> T getProxy(T o){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(o.getClass());
        enhancer.setCallback(methodInterceptor);
        return (T) enhancer.create(new Class[]{String.class},new Object[]{"Gavin"});
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy(new AnimalMethodInterceptor());
        Person person = (Person) cglibProxy.getProxy(new Person("Gavin"));
        person.eat();
    }
}
