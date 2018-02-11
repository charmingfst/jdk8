package org.chm.inteceptor;

/**
 * Created by charming on 2017/8/12.
 */
@MethodName("execute1")
public class InteceptorImpl implements Inteceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Go Go Go!!!");
        return invocation.proceed();
    }

    @Override
    public Object register(Object target) {
        return TargetProxy.bind(target, this);
    }
}
