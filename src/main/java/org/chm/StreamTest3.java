package org.chm;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by charming on 2017/2/13.
 */
public class StreamTest3 {
    public static void main(String[] args) {
//        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        stream.findFirst().ifPresent(System.out::print);

//        Stream<List> stream = Stream.of(Arrays.asList(1), Arrays.asList(1,2), Arrays.asList(1,2,3));
//        stream.flatMap(theList -> theList.stream().map(item -> item)).forEach(System.out::println);

//        Stream.iterate(1, item -> item+2).limit(6).forEach(System.out::println);
//        System.out.println("----------");
        Stream<Integer> stream = Stream.iterate(1, item -> item+2).limit(6);
//        stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum();//.reduce(0, (val, val2)->val+val2);
//        System.out.println(sum);
        IntSummaryStatistics summaryStatistics = stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).summaryStatistics();
        System.out.println(summaryStatistics.getAverage());

        System.out.println("------------");

        //distinct()的顺序造成程序执行结果的不同
//        Stream.iterate(0, i -> (i+1)%2 ).distinct().limit(6).forEach(System.out::println);
        Stream.iterate(0, i -> (i+1)%2 ).limit(6).distinct().forEach(System.out::println);

    }
}
