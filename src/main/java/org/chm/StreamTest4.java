package org.chm;

import org.chm.entity.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.L;

/**
 * Created by charming on 2017/2/17.
 */
public class StreamTest4 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello world", "hello welcome", "world hello welcome");
        list.stream().map(item->item.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        //flatMap
        List<String> list2 = Arrays.asList("hi", "hello");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu");
        list2.stream().flatMap(value -> list3.stream().map(item -> value+" "+item)).forEach(System.out::println);


        Student s1 = new Student("zhangsan", 100);
        Student s2 = new Student("lisi", 92);
        Student s3 = new Student("wangwu", 89);
        Student s4 = new Student("wangwu", 80);
        Student s5 = new Student("wangwu", 80);

        //分组
        List<Student> list1 = Arrays.asList(s1, s2, s3, s4, s5);
        //根据名称分组
//        Map<String, List<Student>> map = list1.stream().collect(Collectors.groupingBy(Student::getName));
//        Map<String, Long> map = list1.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        //先根据名称分组，然后求每组平均分
        Map<String, Double> map  = list1.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(map);

        //分区
        Map<Boolean, List<Student>> map1 = list1.stream().collect(Collectors.partitioningBy(item -> item.getScore() >= 90));
        System.out.println(map1);

        System.out.println("------2-----");

        //先根据名称分组再根据分数分组
        Map<String, Map<Integer, List<Student>>> map2 = list1.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getScore)));
        System.out.println(map2);

        System.out.println("------3-----");
        Map<Integer, Integer> map3 = list1.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.summingInt(Student::getScore)));
        System.out.println(map3);

    }
}
