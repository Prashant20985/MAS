package Bag;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseEnrollmentTest {
    private Course math;
    private Course science;
    private Student student1;
    private Student student2;

    @Before
    public void setUp() {
        math = new Course("Math");
        science = new Course("Science");
        student1 = new Student("Name1", "LastName1");
        student2 = new Student("Name2", "lastName2");
    }

    @Test
    public void testAddEnrollment() {
        math.addEnrollment(student1);
        assertEquals(1, math.getEnrollments().size());
        assertTrue(math.hasEnrolment(student1));
    }

    @Test(expected = RuntimeException.class)
    public void testAddDuplicateEnrollment() {
        math.addEnrollment(student1);
        math.addEnrollment(student1);
    }

    @Test
    public void testRemoveEnrollment() {
        math.addEnrollment(student1);
        math.removeEnrollment(student1);
        assertEquals(0, math.getEnrollments().size());
        assertFalse(math.hasEnrolment(student1));
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveNonexistentEnrollment() {
        math.removeEnrollment(student1);
    }

    @Test
    public void testAddEnrollmentToMultipleCourses() {
        math.addEnrollment(student1);
        science.addEnrollment(student1);
        assertEquals(2, student1.getEnrollments().size());
    }

    @Test
    public void testRemoveEnrollmentFromMultipleCourses() {
        math.addEnrollment(student1);
        science.addEnrollment(student1);
        science.removeEnrollment(student1);
        assertEquals(1, student1.getEnrollments().size());
    }

    @Test
    public void testGetEnrollments() {
        math.addEnrollment(student1);
        math.addEnrollment(student2);
        assertEquals(2, math.getEnrollments().size());
        assertTrue(math.hasEnrolment(student1));
        assertTrue(math.hasEnrolment(student2));
    }
}