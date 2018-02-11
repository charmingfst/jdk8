package org.chm.inteceptor;

/**
 * Created by charming on 2017/8/12.
 */
public interface Inteceptor {
    Object intercept(Invocation invocation)throws Throwable;
    Object register(Object target);
}
