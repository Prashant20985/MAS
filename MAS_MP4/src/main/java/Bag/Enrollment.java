package Bag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Enrollment {
    private Course course;
    private Student student;

    public Enrollment(Course course, Student student) {
        setCourse(course);
        setStudent(student);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if(course == null){
            throw new IllegalArgumentException("Course must not be null");
        }
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        if(student == null){
            throw new IllegalArgumentException("student must not be null");
        }
        this.student = student;
    }
}
