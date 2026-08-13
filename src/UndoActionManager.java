import java.util.Scanner;
import java.util.Stack;

public class UndoActionManager {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Create Stack to store user actions
        Stack<String> actionStack = new Stack<>();

        // Declare variables
        int numberOfActions;
        int choice;
        String action;
        int position;

        // Ask the user to enter the number of actions
        System.out.print("Enter the number of actions: ");
        numberOfActions = scanner.nextInt();
        scanner.nextLine(); // Clear input buffer

        // Check if the number of actions is valid
        if (numberOfActions <= 0) {
            IO.println("Invalid number of actions.");
        } else {

            // Read and store the initial actions
            for (int i = 1; i <= numberOfActions; i++) {
                // Validation Loop: Keep asking until user enters a non-empty string
                do {
                    System.out.print("Enter action " + i + ": ");
                    action = scanner.nextLine().trim(); // trim() removes leading/trailing spaces

                    if (action.isEmpty()) {
                        IO.println("Error: Action cannot be empty. Please try again.");
                    }
                } while (action.isEmpty());

                actionStack.push(action);
            }

            // Display the menu until the user chooses Exit
            do {

                IO.println("\n========== Undo Action Menu ==========");
                IO.println("1. Add Action");
                IO.println("2. Undo Last Action");
                IO.println("3. View Last Action");
                IO.println("4. Search Action");
                IO.println("5. Display All Actions");
                IO.println("6. Display Action Statistics");
                IO.println("7. Clear All Actions");
                IO.println("8. Exit");
                IO.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Clear input buffer

                // Process the user's choice
                switch (choice) {

                    // Add Action (With Validation)
                    case 1:
                        System.out.print("Enter new action: ");
                        action = scanner.nextLine().trim();

                        if (action.isEmpty()) {
                            IO.println("Error: Action cannot be empty. Action was not added.");
                        } else {
                            actionStack.push(action);
                            IO.println("Action added successfully.");
                        }
                        break;

                    // Undo Last Action
                    case 2:
                        if (actionStack.isEmpty()) {
                            IO.println("No actions to undo.");
                        } else {
                            IO.println("Removed Action: " + actionStack.pop());
                        }
                        break;

                    // View Last Action
                    case 3:
                        if (actionStack.isEmpty()) {
                            IO.println("No actions available.");
                        } else {
                            IO.println("Last Action: " + actionStack.peek());
                        }
                        break;

                    // Search Action
                    case 4:
                        System.out.print("Enter action to search: ");
                        action = scanner.nextLine().trim();

                        if (action.isEmpty()) {
                            IO.println("Error: Search query cannot be empty.");
                        } else {
                            position = actionStack.search(action);

                            if (position == -1) {
                                IO.println("Action not found.");
                            } else {
                                IO.println("Action found at position " + position + " from the top.");
                            }
                        }
                        break;

                    // Display All Actions
                    case 5:
                        if (actionStack.isEmpty()) {
                            IO.println("No actions available.");
                        } else {
                            IO.println("Actions in Stack:");
                            for (String item : actionStack) {
                                IO.println(item);
                            }
                        }
                        break;

                    // Display Action Statistics
                    case 6:
                        IO.println("\n----- Action Statistics -----");
                        IO.println("Total number of actions: " + actionStack.size());

                        if (actionStack.isEmpty()) {
                            IO.println("Most recent action: No actions available.");
                        } else {
                            IO.println("Most recent action: " + actionStack.peek());
                        }

                       IO.println("Is Stack Empty? " + actionStack.isEmpty());
                        break;

                    // Clear All Actions
                    case 7:
                        actionStack.clear();
                        IO.println("All actions have been cleared.");
                        break;

                    // Exit
                    case 8:
                        IO.println("Program terminated.");
                        break;

                    // Invalid choice
                    default:
                        IO.println("Invalid choice. Please try again.");
                }

            } while (choice != 8);
        }

        // Close the Scanner
        scanner.close();
    }
}