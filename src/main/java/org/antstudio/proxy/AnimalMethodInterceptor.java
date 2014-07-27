package org.antstudio.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Gavin
 * @date 14-7-27 下午4:43
 */
public class AnimalMethodInterceptor implements MethodInterceptor{


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib proxy before method:"+method.getName());
        Object result =  methodProxy.invokeSuper(o, objects);
        //如果这里调用  method.invoke(o,objects)-->会抛出异常,因为调用method时，会触发拦截器，在拦截器里又调用method，会产生死循环
        System.out.println("Cglib proxy after method:"+method.getName());
        return result;
    }
}
