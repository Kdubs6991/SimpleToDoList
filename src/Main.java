import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scnr.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    listTasks();
                    break;
                case "3":
                    markTaskDone();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- To-Do List ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Done");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addTask(){
        System.out.print("Enter task description: ");
        String desc = scnr.nextLine();
        Task task = new Task(desc);
        tasks.add(task);
        System.out.println("Task added.");
    }

    private static void listTasks(){
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void markTaskDone(){
        listTasks();
        System.out.print("Enter task number to mark as done: ");
        int num = Integer.parseInt(scnr.nextLine()) - 1;
        if (num >= 0 && num < tasks.size()) {
            tasks.get(num - 1).markAsDone();
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask() {
        listTasks();
        System.out.print("Enter task number to delete: ");
        int num = Integer.parseInt(scnr.nextLine()) - 1;
        if (num >= 0 && num < tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
