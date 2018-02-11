package org.chm;

import org.chm.entity.Student;

import java.util.Arrays;
import java.util.List;

/**
 * Created by charming on 2017/2/10.
 */
public class MethodReferenceTest {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 50);
        Student s2 = new Student("lisi", 80);
        Student s3 = new Student("wangwu", 60);
        Student s4 = new Student("zhaoliu", 70);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);

//        list.sort((std1, std2)-> Student.compareByName(std1, std2) );
//        list.forEach(item -> System.out.println(item.getName()));
//        list.sort(Student::compareStudentByName);
//        list.forEach(item -> System.out.println(item.getName()));

//        list.sort(Student::compareByName);
//        list.forEach(item -> System.out.println(item.getName()));
        list.sort((std1, std2)->std1.compareByName(std2));
        list.forEach(item -> System.out.println(item.getName()));
    }
}
