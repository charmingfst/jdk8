package org.chm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by charming on 2017/2/10.
 */
public class StreamTest2 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "jdk8");
//        String[] strs = stream.toArray(value -> new String[value]);
//                System.out.println( stream.toArray()[1]);
        /**
         * Exception in thread "main" java.lang.ClassCastException:
         * [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
         */
//        String[] strs = (String[]) stream.toArray();
//        Arrays.asList(strs).forEach(System.out::println);
        for (Object obj : stream.toArray())
        {
            System.out.println(obj);
        }


//        List<String> list = stream.collect(Collectors.toList());
//        List<String> list = stream.collect(()->new ArrayList<String>(), (theList, item) -> theList.add(item), (list1, list2)->list1.addAll(list2));
//        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        list.forEach(System.out::println);

//        String str = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
//
//        System.out.println(str);


    }
}
