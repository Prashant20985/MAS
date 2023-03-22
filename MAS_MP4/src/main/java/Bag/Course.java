package Bag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Course {
    private String name;
    private final Set<Enrollment> enrollments = new HashSet<>();

    public Course(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name must not be null or Empty");
        }
        this.name = name;
    }

    public Set<Enrollment> getEnrollments() {
        return Collections.unmodifiableSet(enrollments);
    }

    public void addEnrollment(Student student){
        if(hasEnrolment(student)){
            throw new RuntimeException("Student is already enrolled");
        }
        Enrollment enrollment = new Enrollment(this, student);
        enrollments.add(enrollment);
        student.addEnrollment(enrollment);
    }

    public void removeEnrollment(Student student){
        if(!hasEnrolment(student)){
            throw new RuntimeException("Student is not enrolled");
        }
        Enrollment enrollmentToRemove = enrollments.stream()
                .filter(x -> x.getStudent().equals(student)).findFirst().get();
        enrollments.remove(enrollmentToRemove);
        student.removeEnrollment(enrollmentToRemove);
    }

    public boolean hasEnrolment(Student student){
        if(enrollments.stream().anyMatch(x -> x.getStudent().equals(student))){
            return true;
        }
        return false;
    }
}
