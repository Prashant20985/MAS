package Ordered;

import sun.util.resources.LocaleData;

import java.time.LocalDate;

public class Task implements Comparable<Task>{

    private String title;
    private String description;
    private int priority;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String title, String description, int priority, LocalDate dueDate) {
        setTitle(title);
        setDescription(description);
        setPriority(priority);
        setDueDate(dueDate);
        setCompleted(false);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null || description.isEmpty()){
            throw new IllegalArgumentException("description must not be empty");
        }
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        if(dueDate.isBefore(LocalDate.now().minusDays(1))){
            throw new IllegalArgumentException("Due date must today or a further Date");
        }
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int compareTo(Task o) {
        int result = Integer.compare(this.priority, o.priority);
        if(result == 0){
            result = this.dueDate.compareTo(o.dueDate);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                ", completed=" + completed +
                '}';
    }
}
