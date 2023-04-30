package Basic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//1 Student can be in Multiple groups
public class Student {
    private int id;
    private String firstName;
    private String lastName;

    private static final Set<Student> extent = new HashSet<>();

    private final Set<Group> groups = new HashSet<>();

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        setFirstName(firstName);
        setFirstName(lastName);
        extent.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("Firstname cannot be null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Lastname cannot be null");
        }
        this.lastName = lastName;
    }

    public Set<Group> getGroups() {
        return Collections.unmodifiableSet(groups);
    }

    public void addGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException("Group must me null");
        }
        if (groups.contains(group)) return;

        groups.add(group);
        group.addStudent(this);
    }

    public void removeGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException("Group must not be null");
        }
        if (!groups.contains(group)) return;
        groups.remove(group);
        group.removeStudent(this);
    }

    public static Set<Student> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public static void delete(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student must not be null");
        }
        Set<Group> groupTemp = Set.copyOf(student.groups);
        student.groups.clear();
        groupTemp.forEach(x -> x.removeStudent(student));
        extent.remove(student);
    }
}
