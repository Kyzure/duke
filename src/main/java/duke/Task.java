import java.io.Serializable;

import java.time.format.DateTimeFormatter;

/**
 * Represents a Task given by the User that is parsed by the parser to store information
 * that can be easily printed out in readable format. 
 */
class Task implements Serializable {
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    private static final String CIRCLE = "O";    
    private static final String CROSS = "X";  

    private String task;
    private boolean isCompleted;

    /**
     * Constructor for Task. 
     * 
     * @param task A String of the user's inputted task
     */
    public Task(String task) {
        this.task = task;
        this.isCompleted = false;
    }
    
    public boolean hasCompleted() {
        return this.isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getTaskString() {
        return this.task;
    }

    @Override
    public String toString() {
        if (this.isCompleted) {
            return "[" + CIRCLE + "] " + this.task;
        } else {
            return "[" + CROSS + "] " + this.task;
        }
    }
}