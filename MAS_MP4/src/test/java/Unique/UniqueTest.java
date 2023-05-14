package Unique;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueTest {

    private Department department;
    Employee employee;
    @Before
    public void setUp() throws Exception {
        department = new Department();
        employee = new Employee("EMP 1");
    }

    @Test
    public void assignDepartment() {
        department.assignDepartment(employee);
        assertEquals(1, department.getEmployees().size());
        assertThrows(IllegalArgumentException.class,
                () -> department.assignDepartment(employee));
    }

}