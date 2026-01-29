import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Get tasks from getTask file.
        ArrayList<String> tasks = getTask.getTasks();

        // Hand off to the task handler (menu / printing / editing happens there)
        handleTasks.run(tasks);
    }
}

