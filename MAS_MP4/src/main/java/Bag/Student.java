package Bag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Student {

    private String firstName;
    private String lastName;
    private Set<Enrollment> enrollments = new HashSet<>();

    public Student(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isBlank()){
            throw new IllegalArgumentException("firstName should not be null or empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("lastName should not be null or empty");
        }
        this.lastName = lastName;
    }

    public Set<Enrollment> getEnrollments() {
        return Collections.unmodifiableSet(enrollments);
    }

    public void addEnrollment(Enrollment enrollment){
        if(enrollment == null){
            throw new IllegalArgumentException("Enrollment should not be null");
        }
        if(enrollments.contains(enrollment)) return;

        enrollments.add(enrollment);
    }

    public void removeEnrollment(Enrollment enrollment){
        if(enrollment == null){
            throw new IllegalArgumentException("Enrollment should not be null");
        }
        if(!enrollments.contains(enrollment)) return;

        enrollments.remove(enrollment);
    }
}
