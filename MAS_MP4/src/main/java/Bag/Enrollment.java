package Bag;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Enrollment {
    private static final Set<Enrollment> extent = new HashSet<>();
    private Course course;
    private Student student;
    private LocalDate startDate;
    private LocalDate endDate;

    public Enrollment(Course course, Student student) {
        validateEnrollment(course, student);
        setStudent(student);
        setCourse(course);
        setStartDate(LocalDate.now());
        student.addEnrollment(this);
        course.addEnrollment(this);
        extent.add(this);
    }

    public static void validateEnrollment(Course course, Student student) {
        if (extent.stream().anyMatch(enrollment -> enrollment.course.equals(course)
                && enrollment.student.equals(student) && enrollment.endDate == null)) {
            throw new IllegalArgumentException("Student Already assigned to the course");
        }
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course == null)
            throw new IllegalArgumentException("Course must not be null");
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student must not be null");
        this.student = student;
    }

    public static Set<Enrollment> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate == null)
            throw new IllegalArgumentException("Start Date cannot be null");
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate == null || startDate.isAfter(endDate))
            throw new IllegalArgumentException("End cannot be before Start date");
        this.endDate = endDate;
    }

    public void leaveCourse() {
        setEndDate(LocalDate.now());
    }

    public static void delete(Enrollment enrollment) {
        if (enrollment == null)
            throw new IllegalArgumentException("Enrollment cannot be null");
        enrollment.student.removeEnrollment(enrollment);
        enrollment.course.removeEnrollment(enrollment);
        extent.remove(enrollment);
    }
}
