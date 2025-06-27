package ConsoleVersion;
import java.util.Scanner;
/**
 * To-Do List App
 * (ConsoleVersion.Main Program)
 * @author Kaleb Wrigley
 * @version 1.1
 * @since 06-27-2025
 */
public class Main {
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            TaskActions.printMenu();
            String choice = scnr.nextLine();

            switch (choice) {
                case "1":
                    TaskActions.addTask();
                    break;
                case "2":
                    TaskActions.listTasks();
                    break;
                case "3":
                    TaskActions.markTaskDone();
                    break;
                case "4":
                    TaskActions.deleteTask();
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
}
