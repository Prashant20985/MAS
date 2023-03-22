package Basic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void addStudent() {
        Student student1 = new Student(1,"Prashant", "Sharma");
        Student student2 = new Student(2,"Vatsal", "Patel");
        Group group1 = new Group("group1");
        assertEquals(0, group1.getStudents().size());
        assertEquals(0, student1.getGroups().size());
        assertEquals(0, student2.getGroups().size());
        group1.addStudent(student1);
        group1.addStudent(student2);
        assertEquals(2, group1.getStudents().size());
        assertEquals(1, student1.getGroups().size());
        assertEquals(1, student2.getGroups().size());
    }

    @Test
    public void removeStudent(){
        Student student1 = new Student(1,"Prshant", "Sharma");
        Student student2 = new Student(2,"Vatsal", "Patel");
        Group group1 = new Group("group1");
        assertEquals(0, group1.getStudents().size());
        assertEquals(0, student1.getGroups().size());
        assertEquals(0, student2.getGroups().size());
        group1.addStudent(student1);
        group1.addStudent(student2);
        assertEquals(2, group1.getStudents().size());
        assertEquals(1, student1.getGroups().size());
        assertEquals(1, student2.getGroups().size());
        group1.removeStudent(student1);
        assertEquals(1, group1.getStudents().size());
        assertEquals(0, student1.getGroups().size());
        assertEquals(1, student2.getGroups().size());
        group1.removeStudent(student2);
        assertEquals(0, group1.getStudents().size());
        assertEquals(0, student1.getGroups().size());
        assertEquals(0, student2.getGroups().size());
    }

    @Test
    public void deleteGroup(){
        Student student1 = new Student(1,"Prshant", "Sharma");
        Student student2 = new Student(2,"Vatsal", "Patel");
        Group group1 = new Group("group1");
        assertEquals(0, group1.getStudents().size());
        assertEquals(0, student1.getGroups().size());
        assertEquals(0, student2.getGroups().size());
        group1.addStudent(student1);
        group1.addStudent(student2);
        assertEquals(2, group1.getStudents().size());
        assertEquals(1, student1.getGroups().size());
        assertEquals(1, student2.getGroups().size());
        Group.delete(group1);
        assertEquals(0, student1.getGroups().size());
        assertEquals(0, student2.getGroups().size());
    }

}