package org.chm.inteceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by charming on 2017/8/12.
 * mybatis中Interceptor，使用动态代理实现
 */
public class TargetProxy implements InvocationHandler {

    private Object target;
    private Inteceptor interceptor;

    private TargetProxy(Object target, Inteceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    //将拦截逻辑封装到拦截器中，有客户端生成目标类的代理类的时候一起传入，这样客户端就可以设置不同的拦截逻辑。
    public static Object bind(Object target, Inteceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TargetProxy(target, interceptor));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodName methodName = this.interceptor.getClass().getAnnotation(MethodName.class);
        if (methodName == null)
            throw new NullPointerException("xxxx");

        //如果注解上的方法名和该方法名一样，才拦截
        String name = methodName.value();
        if (name.equals(method.getName()))
            return interceptor.intercept(new Invocation(target,    method, args));

        return method.invoke(this.target, args);
    }
}
