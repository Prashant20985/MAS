package Unique;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Department {
    private final Set<Employee> employees = new HashSet<>();

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(employees);
    }

    public void assignDepartment(Employee employee) {
        if(employee == null)
            throw new IllegalArgumentException("Employee cannot be null");
        if (employees.contains(employee))
            throw new IllegalArgumentException("Employee already assigned a department");
        employees.add(employee);
    }
}
