package Ordered;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TaskManagerTest {

    private TaskManager taskManager;
    @Before
    public void setUp() throws Exception {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask(){
        Task task1 = new Task("Task1", "Test task", 1, LocalDate.now());
        taskManager.addTask(task1);
        assertEquals(1, taskManager.getTasks().size());
        assertEquals(task1, taskManager.getTasks().get(0));
    }

    @Test
    public void testRemoveTask(){
        Task task1 = new Task("Task1", "Test task", 1, LocalDate.now());
        taskManager.addTask(task1);
        assertEquals(1, taskManager.getTasks().size());
        taskManager.removeTask(task1);
        assertEquals(0, taskManager.getTasks().size());
        assertTrue(!taskManager.getTasks().contains(task1));
    }

    @Test
    public void testGetCompletedTask(){
        Task task1 = new Task("Task1", "Test task1", 1, LocalDate.now());
        Task task2 = new Task("Task2", "Test task2", 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task3", "Test task3", 3, LocalDate.now().plusDays(2));
        task1.setCompleted(true);
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        assertEquals(1, taskManager.getCompletedTasks().size());
        assertEquals(task1, taskManager.getCompletedTasks().get(0));
    }

    @Test
    public void testGetIncompleteTasks(){
        Task task1 = new Task("Task1", "Test task1", 1, LocalDate.now());
        Task task2 = new Task("Task2", "Test task2", 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task3", "Test task3", 3, LocalDate.now().plusDays(2));
        task1.setCompleted(true);
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        assertEquals(2, taskManager.getIncompleteTasks().size());
        assertEquals(task2, taskManager.getIncompleteTasks().get(0));
        assertEquals(task3, taskManager.getIncompleteTasks().get(1));
    }

    @Test
    public void testFindByTitle(){
        Task task1 = new Task("Task 1", "Test task1", 1, LocalDate.now());
        Task task2 = new Task("Task 2", "Test task2", 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Another one", "Test task3", 3, LocalDate.now().plusDays(2));
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        assertEquals(2, taskManager.searchByTitle("task").size());
        assertEquals(task1, taskManager.getTasks().get(0));
        assertEquals(task2, taskManager.getTasks().get(1));
    }

    @Test
    public void testFindByPrority(){
        Task task1 = new Task("Task 1", "Test task1", 1, LocalDate.now());
        Task task2 = new Task("Task 2", "Test task2", 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Another one", "Test task3", 1, LocalDate.now().plusDays(2));
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        assertEquals(2, taskManager.findByPriority(1).size());
        assertEquals(task1, taskManager.getTasks().get(0));
        assertEquals(task3, taskManager.getTasks().get(1));
    }
}