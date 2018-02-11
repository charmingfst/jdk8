package org.chm;

import java.util.Arrays;
import java.util.List;

/**
 * Created by charming on 2018/2/9.
 */
public class StreamTest6 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "welcome");

        //没有中间操作，调用ReferencePipeline.Head中的forEach方法，直接针对流源操作
//        list.stream().forEach(System.out::println);

        //如果有中间操作，调用ReferencePipeline中的forEach方法
        list.stream().map(it -> it.length()).forEach(System.out::println);

        list.iterator().forEachRemaining(System.out::println);

    }
}
