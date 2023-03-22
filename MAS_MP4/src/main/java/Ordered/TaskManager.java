package Ordered;

import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private static List<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        if(task == null){
            throw new IllegalArgumentException("Task must not be null");
        }
        tasks.add(task);
    }

    public void removeTask(Task task){
        if(task == null){
            throw new IllegalArgumentException("Task must not be null");
        }
        if(!tasks.contains(task)){
            throw new IllegalArgumentException("Task does not exists");
        }
        tasks.remove(task);
    }

    public List<Task> getTasks(){
        return tasks.stream()
                .sorted(Comparator.comparingInt(Task::getPriority)
                        .thenComparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

    public List<Task> getCompletedTasks(){
        return tasks.stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }

    public List<Task> getIncompleteTasks(){
        return tasks.stream()
                .filter(x -> !x.isCompleted())
                .collect(Collectors.toList());
    }

    public List<Task> searchByTitle(String title){
        return tasks.stream()
                .filter(x -> x.getTitle().toLowerCase().contains(title))
                .sorted(Comparator.comparingInt(Task::getPriority)
                        .thenComparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

    public List<Task> findByPriority(int priority){
        return tasks.stream()
                .filter(x -> x.getPriority() == priority)
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }
}
