package Bag;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseEnrollmentTest {

    @Test
    public void Test() {
        Student student = new Student("Test", "Test");
        Course course = new Course("C1");
        Enrollment enrollment = new Enrollment(course, student);
        assertThrows(IllegalArgumentException.class, () -> new Enrollment(course, student));
        assertEquals(1, Enrollment.getExtent().size());
        enrollment.leaveCourse();
        Enrollment enrollment1 = new Enrollment(course, student);
        assertEquals(2, Enrollment.getExtent().size());
        enrollment.leaveCourse();
        assertEquals(2, Enrollment.getExtent().size());
        Enrollment.delete(enrollment);
        assertEquals(1, Enrollment.getExtent().size());
        assertTrue(Enrollment.getExtent().contains(enrollment1));
    }
}