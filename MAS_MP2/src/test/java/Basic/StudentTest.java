package Basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void addGroup() {
        Student student1 = new Student(1, "Prshant", "Sharma");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        assertEquals(0, group1.getStudents().size());
        assertEquals(0, group2.getStudents().size());
        assertEquals(0, student1.getGroups().size());
        student1.addGroup(group1);
        student1.addGroup(group2);
        assertEquals(1, group1.getStudents().size());
        assertEquals(1, group2.getStudents().size());
        assertEquals(2, student1.getGroups().size());
    }

    @Test
    public void removeStudent() {
        Student student1 = new Student(1, "Prshant", "Sharma");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        assertEquals(0, group1.getStudents().size());
        assertEquals(0, group2.getStudents().size());
        assertEquals(0, student1.getGroups().size());
        student1.addGroup(group1);
        student1.addGroup(group2);
        assertEquals(1, group1.getStudents().size());
        assertEquals(1, group2.getStudents().size());
        assertEquals(2, student1.getGroups().size());
        student1.removeGroup(group1);
        assertEquals(0, group1.getStudents().size());
        assertEquals(1, group2.getStudents().size());
        assertEquals(1, student1.getGroups().size());
        student1.removeGroup(group2);
        assertEquals(0, group1.getStudents().size());
        assertEquals(0, group2.getStudents().size());
        assertEquals(0, student1.getGroups().size());
    }

    @Test
    public void deleteGroup() {
        Student student1 = new Student(1, "Prshant", "Sharma");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        assertEquals(0, group1.getStudents().size());
        assertEquals(0, group2.getStudents().size());
        assertEquals(0, student1.getGroups().size());
        student1.addGroup(group1);
        student1.addGroup(group2);
        assertEquals(1, group1.getStudents().size());
        assertEquals(1, group2.getStudents().size());
        assertEquals(2, student1.getGroups().size());
        Student.delete(student1);
        assertEquals(0, group1.getStudents().size());
        assertEquals(0, group2.getStudents().size());
    }
}