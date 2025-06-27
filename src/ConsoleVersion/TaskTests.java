package ConsoleVersion;

import java.util.List;

public class TaskTests {

    public static void main(String[] args) {
        testAddTask();
        testMarkTaskDone();
        testDeleteTask();
    }

    private static void testAddTask() {
        System.out.println("-- Testing addTask: --");
        TaskActions.addTask("Buy groceries");
        List<Task> tasks = TaskActions.getAllTasks();

        boolean found = false;
        for (Task task : tasks) {
            if (task.getDescription().equals("Buy groceries")) {
                found = true;
                break;
            }
        }
        if (found){
            System.out.println("testAddTask passed.");
            TaskActions.listTasks();
            System.out.println("-----------");
            return;
        } else {
            System.out.println("testAddTask failed.");
        }
        assert tasks.size() == 1 : "Test failed: Task count should be 1";
        assert !tasks.get(0).isDone() : "Test failed: Task should not be marked as done";
        System.out.println("testAddTask passed.");
    }


    private static void testMarkTaskDone() {
        System.out.println("-- Testing MarkTaskDone: --");
        TaskActions.addTask("Do homework");
        TaskActions.markTaskDone(1);
        List<Task> tasks = TaskActions.getAllTasks();

        boolean foundDone = false;
        for (Task task : tasks) {
            if (task.getDescription().equals("Do homework") && task.isDone()) {
                foundDone = true;
                break;
            }
        }

        if (foundDone) {
            System.out.println("testMarkTaskDone passed.");
            TaskActions.listTasks();
            System.out.println("-----------");
        } else {
            System.out.println("testMarkTaskDone failed.");
        }

        boolean expected = true;
        boolean result = tasks.get(1).isDone();
        assert result == expected : "Expected task to be done: " + expected + ", but got: " + result;
    }

    private static void testDeleteTask() {
        System.out.println("-- Testing DeleteTask: --");
        // Add task to be deleted
        TaskActions.addTask("Call mom");
        // Delete the task (should now be at index 2)
        TaskActions.deleteTasks(2);
        List<Task> tasks = TaskActions.getAllTasks();

        boolean found = false;
        for (Task task : tasks) {
            if (task.getDescription().equals("Call mom")) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("testDeleteTask passed. Task was successfully deleted.");
            TaskActions.listTasks();
            System.out.println("-----------");
        } else {
            System.out.println("testDeleteTask failed. Task still exists in list.");
        }

        int expected = 2;
        int result = tasks.size();
        assert result == expected : "Expected task list size after delete: " + expected + ", but got: " + result;
    }
}
