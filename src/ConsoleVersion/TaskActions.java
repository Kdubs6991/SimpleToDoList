package ConsoleVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskActions {
    private static TaskManager taskManager = new TaskManager();
    private static Scanner scnr = new Scanner(System.in);

    public static List<Task> getAllTasks() {
        return taskManager.getAllTasks();
    }

    public static void printMenu() {
        System.out.println("\n--- To-Do List ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Done");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    public static void addTask(){
        System.out.print("Enter task description: ");
        String desc = scnr.nextLine();
        Task task = new Task(desc);
        taskManager.addTask(desc);
        System.out.println("Task added.");
    }

    public static void addTask(String desc) {
        taskManager.addTask(desc);
    }

    public static void listTasks(){
        List<Task> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void markTaskDone(){
        List<Task> tasks = taskManager.getAllTasks();
        listTasks();
        System.out.print("Enter task number to mark as done: ");
        int num = Integer.parseInt(scnr.nextLine()) - 1;
        if (num >= 0 && num < tasks.size()) {
            tasks.get(num).markAsDone();
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void markTaskDone(int num) {
        List<Task> tasks = taskManager.getAllTasks();
        listTasks();
        if (num >= 0 && num < tasks.size()) {
            tasks.get(num).markAsDone();
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void deleteTask() {
        List<Task> tasks = taskManager.getAllTasks();
        listTasks();
        System.out.print("Enter task number to delete: ");
        int num = Integer.parseInt(scnr.nextLine()) - 1;
        if (num >= 0 && num < tasks.size()) {
            tasks.remove(num);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void deleteTasks(int num){
        List<Task> tasks = taskManager.getAllTasks();
        listTasks();
        if (num >= 0 && num < tasks.size()) {
            tasks.remove(num);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
