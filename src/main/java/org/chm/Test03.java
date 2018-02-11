package org.chm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by charming on 2017/1/7.
 */
public class Test03 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list );

        System.out.println(new Test03().convert(2, value -> value+"he"));
    }

    public String convert(int a, Function<Integer, String> fun)
    {
        return  fun.apply(a);
    }


}
