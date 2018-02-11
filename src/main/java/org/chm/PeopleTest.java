package org.chm;

import org.chm.entity.People;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by charming on 2017/2/6.
 */
public class PeopleTest {

    public static void main(String[] args) {

        People p1 = new People("zhangsan", 20);
        People p2 = new People("lisi", 30);
        People p3 = new People("wangwu", 40);

        List<People> list = Arrays.asList(p1, p2, p3);

        PeopleTest test = new PeopleTest();
        List<People> list1 = test.getPeoplesByName("zhangsan", list);
        list1.forEach(people -> System.out.println(people.getName()));

        list1 = test.getPeoplesByAge(20, list);
        list1.forEach(people -> System.out.println(people.getName()));

        Predicate<String> predicate = str -> str.length() > 5;
        System.out.println(predicate.test("hello"));

    }

    public List<People> getPeoplesByName(String name, List<People> list)
    {
        return list.stream().filter(people -> people.getName().equals(name)).collect(Collectors.toList());
    }

    public List<People> getPeoplesByAge(int age, List<People> list)
    {
        BiFunction<Integer, List<People>, List<People>> biFunction = (theAge, theList)-> theList.stream().filter(people -> people.getAge() > theAge).collect(Collectors.toList());
        return biFunction.apply(age, list);
    }
}
