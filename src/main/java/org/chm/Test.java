package org.chm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by charming on 2016/12/27.
 */
public class Test {
    @FunctionalInterface
    public interface MyLuence
    {
        void sayHello(String str);
        @Override
        boolean equals(Object obj);

        default void getName()
        {
            System.out.println("name is chm");
        }

    }
    public static void main(String[] args) {
//        System.out.println("hello world");
        MyLuence myLuence = (str)-> System.out.println("hello:" + str);
        myLuence.sayHello("chm");
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        list.forEach(para1 -> System.out.println(para1));
        myLuence.getName();
        list.forEach(System.out::println);

        String str = "aa";
        List<String> list1 = Arrays.asList("hello", "world", "chm");
        list1.stream().map(String::toUpperCase).forEach(item-> System.out.println(item));

    }
}
