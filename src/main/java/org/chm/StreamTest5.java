package org.chm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by charming on 2018/2/7.
 */
public class StreamTest5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "java");

        try (Stream<String> stream = list.stream()){
            stream.onClose(()->{
                System.out.println("aaa");
            }).onClose(()->{
                System.out.println("bbb");
            }).forEach(System.out::println);
        }

    }
}
