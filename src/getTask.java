import java.util.Scanner;
import java.util.ArrayList;

public class getTask {

    public static ArrayList<String> getTasks() {

        // Create the scanner
        Scanner scanner = new Scanner(System.in);

        // Initialize the Array List
        ArrayList<String> itemList = new ArrayList<>();

        // Prompt the user to start entering tasks.
        System.out.println("Start entering tasks. Enter 'quit' when you are finished.");

        // While loop allows the user to add as many tasks as they want.
        while (true) {
            System.out.print("Enter Task: ");

            // Save what the user entered.
            String task = scanner.nextLine();

            // Check if the user wants to quit.
            // If so, break the while loop.
            if (task.equalsIgnoreCase("quit")) {
                break;
            }

            // Add the task.
            itemList.add(task);
        }

        // Return the task so that it can be accessed by the 'Main' file.
        return itemList;
    }
}
