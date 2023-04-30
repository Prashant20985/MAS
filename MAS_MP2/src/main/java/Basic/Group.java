package Basic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//1 Group can have many students
public class Group {
    private String name;

    private static final Set<Group> extent = new HashSet<>();
    private final Set<Student> students = new HashSet<>();

    public Group(String name) {
        this.name = name;
        extent.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name Cannot be null");
        }
        String trimmedName = name.trim();
        if (trimmedName.isBlank()) {
            throw new IllegalArgumentException("Name Should Not be Blank");
        }
        this.name = trimmedName;
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student must not be null");
        }
        if (students.contains(student)) return;
        students.add(student);
        student.addGroup(this);
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student should not be null");
        }
        if (!students.contains(student)) return;

        students.remove(student);
        student.removeGroup(this);
    }

    public static Set<Group> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public static void delete(Group group) {
        if (group == null) {
            throw new IllegalArgumentException("Group must not be null");
        }
        Set<Student> studentTemp = Set.copyOf(group.students);
        group.students.clear();
        studentTemp.forEach(x -> x.removeGroup(group));
        extent.remove(group);
    }
}
