package Bag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Course {
    private String courseName;

    private final Set<Enrollment> enrollments = new HashSet<>();

    public Course(String courseName) {
        setCourseName(courseName);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.isBlank())
            throw new IllegalArgumentException("Course name must not be blank or null");
        this.courseName = courseName;
    }

    public Set<Enrollment> getEnrollments() {
        return Collections.unmodifiableSet(enrollments);
    }

    public void addEnrollment(Enrollment enrollment) {
        if (enrollment == null)
            throw new IllegalArgumentException("Enrollment cannot be null");
        if (enrollments.contains(enrollment)) return;
        enrollments.add(enrollment);
    }

    public void removeEnrollment(Enrollment enrollment){
        if (enrollment == null)
            throw new IllegalArgumentException("Enrollment cannot be null");
        if (!enrollments.contains(enrollment)) return;
        enrollments.remove(enrollment);
    }
}
