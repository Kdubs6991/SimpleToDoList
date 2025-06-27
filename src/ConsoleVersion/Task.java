package ConsoleVersion;

/**
 * This class represents one to-do item
 */
public class Task {
    private String description;
    private boolean isDone; //is the task completed?

    /**
     * Consturctor for the ConsoleVersion.Task class
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Checks if the task is done
     * @return
     */
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Returns the task description
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns a string representation of the task
     * Overrides the general toString() method
     * @return
     */
    @Override
    public String toString() {
        String status = isDone ? "[x]" : "[ ]";
        return status + " " + description;
    }
}