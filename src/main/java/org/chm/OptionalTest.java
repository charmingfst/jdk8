package org.chm;

import org.chm.entity.Company;
import org.chm.entity.Employee;

import java.util.*;

/**
 * Created by charming on 2017/2/7.
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
        optional.ifPresent(value -> System.out.println(value));

        Employee employee1 = new Employee();
        employee1.setName("zhangsan");
        Employee employee2 = new Employee();
        employee1.setName("lisi");

        Company company = new Company();
        company.setName("ali");
        ArrayList<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        company.setEmployees(list);

        Optional<Company> companyOptional = Optional.ofNullable(company);

        List<Employee> ss = companyOptional.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList());
        System.out.println(ss);
    }
}
