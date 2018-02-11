package org.chm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by charming on 2017/3/9.
 */
public class Compare {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "nihao", "welcome");
        Collections.sort(list, String::compareToIgnoreCase);
        list.forEach(System.out::println);
        System.out.println("---------");
        list.sort(Comparator.comparing(item -> item.length(), Comparator.reverseOrder()));
        list.sort(Comparator.comparing((String item) -> item.length()).reversed().thenComparing(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list);
    }
}
