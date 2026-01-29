import java.util.ArrayList;
import java.util.Scanner;

public class handleTasks {

    // Store whether or not a task is checked.
    private static class Task {
        private String text;
        private boolean done;

        Task(String text) {
            this.text = text;
            this.done = false;
        }
    }

    // Main program loop for managing tasks
    public static void run(ArrayList<String> rawTasks) {

        // Initialize task list.
        ArrayList<Task> tasks = new ArrayList<>();
        for (String t : rawTasks) {
            tasks.add(new Task(t));
        }

        // Create the Scanner.
        Scanner scanner = new Scanner(System.in);

        // While loop allows you to manage all tasks.
        while (true) {
            printTasks(tasks);

            System.out.println("\nChoose a task number to manage it, or type 'quit' to exit.");
            System.out.print("Selection: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            int index;
            try {
                index = Integer.parseInt(input) - 1;
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a number (example: 1) or 'quit'.");
                continue;
            }

            // If the user chooses a task number that doesn't exist, give them an error message and
            // make themn try again.
            if (index < 0 || index >= tasks.size()) {
                System.out.println("That task number doesn't exist.");
                continue;
            }

            System.out.println("Selected: " + formatTask(tasks.get(index)));
            System.out.println("Options: [c]heck/uncheck, [e]dit, DELETE, [b]ack");
            System.out.print("Action: ");
            String action = scanner.nextLine().trim();

            // If the user enters 'b', go back.
            if (action.equalsIgnoreCase("b")) {
                continue;
            }

            // If the user enters c, check/uncheck the task.
            else if (action.equalsIgnoreCase("c")) {
                tasks.get(index).done = !tasks.get(index).done;
            }

            // If the user enters e, let the user edit the task.
            else if (action.equalsIgnoreCase("e")) {
                System.out.print("Enter new text: ");
                String newText = scanner.nextLine();
                tasks.get(index).text = newText;
            }

            // If the user enters 'DELETE', delete the task.
            else if (action.equalsIgnoreCase("DELETE")) {
                tasks.remove(index);
            }
            else {
                System.out.println("Unknown action.");
            }
        }
    }

    private static void printTasks(ArrayList<Task> tasks) {
        System.out.println("\nYour tasks:");
        if (tasks.isEmpty()) {
            System.out.println("(no tasks)");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + formatTask(tasks.get(i)));
        }
    }

    private static String formatTask(Task task) {
        return (task.done ? "[x] " : "[ ] ") + task.text;
    }
}
