package org.chm.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charming on 2017/2/7.
 */
public class Company {
    private String name;
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
