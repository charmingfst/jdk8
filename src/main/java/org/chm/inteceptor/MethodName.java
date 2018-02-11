package org.chm.inteceptor;

import java.lang.annotation.*;
import java.lang.annotation.Target;

/**
 * Created by charming on 2017/8/12.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MethodName {
    public String value();
}
