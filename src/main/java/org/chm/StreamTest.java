package org.chm;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by charming on 2017/2/10.
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world");

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Optional<Integer> optional = list.stream().map(value->value*2).reduce((val1, val2)->val1+val2);
        optional.ifPresent(item-> System.out.println(item));
        System.out.println(list.stream().map(value->value*2).reduce(0,Integer::sum));
    }
}
