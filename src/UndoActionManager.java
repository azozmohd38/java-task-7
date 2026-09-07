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
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid number of actions.");
            scanner.next();
            System.out.print("Enter the number of actions: ");
        }

        numberOfActions = scanner.nextInt();
        scanner.nextLine();

        // Check if the number of actions is valid
        if (numberOfActions <= 0) {
            System.out.println("Invalid number of actions.");
        } else {

            // Read and store the initial actions
            for (int i = 1; i <= numberOfActions; i++) {
                do {
                    System.out.print("Enter action " + i + ": ");
                    action = scanner.nextLine().trim();

                    if (action.isEmpty()) {
                        System.out.println("Error: Action cannot be empty. Please try again.");
                    }
                } while (action.isEmpty());

                actionStack.push(action);
            }

            // Display the menu until the user chooses Exit
            do {

                System.out.println("\n========== Undo Action Menu ==========");
                System.out.println("1. Add Action");
                System.out.println("2. Undo Last Action");
                System.out.println("3. View Last Action");
                System.out.println("4. Search Action");
                System.out.println("5. Display All Actions");
                System.out.println("6. Display Action Statistics");
                System.out.println("7. Clear All Actions");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid choice. Please try again.");
                    scanner.next();
                    System.out.print("Enter your choice: ");
                }

                choice = scanner.nextInt();
                scanner.nextLine();

                // Process the user's choice
                switch (choice) {

                    // Add Action (With Validation)
                    case 1:
                        System.out.print("Enter new action: ");
                        action = scanner.nextLine().trim();

                        if (action.isEmpty()) {
                            System.out.println("Error: Action cannot be empty. Action was not added.");
                        } else {
                            actionStack.push(action);
                            System.out.println("Action added successfully.");
                        }
                        break;

                    // Undo Last Action
                    case 2:
                        if (actionStack.isEmpty()) {
                            System.out.println("No actions to undo.");
                        } else {
                            System.out.println("Removed Action: " + actionStack.pop());
                        }
                        break;

                    // View Last Action
                    case 3:
                        if (actionStack.isEmpty()) {
                            System.out.println("No actions available.");
                        } else {
                            System.out.println("Last Action: " + actionStack.peek());
                        }
                        break;

                    // Search Action
                    case 4:
                        System.out.print("Enter action to search: ");
                        action = scanner.nextLine().trim();

                        if (action.isEmpty()) {
                            System.out.println("Error: Search query cannot be empty.");
                        } else {
                            position = actionStack.search(action);

                            if (position == -1) {
                                System.out.println("Action not found.");
                            } else {
                                System.out.println("Action found at position " + position + " from the top.");
                            }
                        }
                        break;

                    // Display All Actions
                    case 5:
                        if (actionStack.isEmpty()) {
                            System.out.println("No actions available.");
                        } else {
                            System.out.println("Actions in Stack:");
                            for (int i = actionStack.size() - 1; i >= 0; i--) {
                                System.out.println(actionStack.get(i));
                            }
                        }
                        break;

                    // Display Action Statistics
                    case 6:
                        System.out.println("\n----- Action Statistics -----");
                        System.out.println("Total number of actions: " + actionStack.size());

                        if (actionStack.isEmpty()) {
                            System.out.println("Most recent action: No actions available.");
                        } else {
                            System.out.println("Most recent action: " + actionStack.peek());
                        }

                       System.out.println("Is Stack Empty? " + actionStack.isEmpty());
                        break;

                    // Clear All Actions
                    case 7:
                        actionStack.clear();
                        System.out.println("All actions have been cleared.");
                        break;

                    // Exit
                    case 8:
                        System.out.println("Program terminated.");
                        break;

                    // Invalid choice
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 8);
        }

        // Close the Scanner
        scanner.close();
    }
}