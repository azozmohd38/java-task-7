import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintQueueManager {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create a Queue using LinkedList to store print job names
        Queue<String> printQueue = new LinkedList<>();

        // Declare variables
        int numberOfJobs;
        int choice;
        String printJobName;

        // Ask the user for the number of print jobs
        System.out.print("Enter the number of print jobs: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid number of print jobs.");
            scanner.next();
            System.out.print("Enter the number of print jobs: ");
        }

        numberOfJobs = scanner.nextInt();
        scanner.nextLine();

        // Check if the number of print jobs is valid
        if (numberOfJobs <= 0) {
            System.out.println("Invalid number of print jobs.");
        } else {

            // Read print job names and add them to the queue
            for (int i = 1; i <= numberOfJobs; i++) {
                System.out.print("Enter print job " + i + ": ");
                printJobName = scanner.nextLine().trim();
                if (!printJobName.isEmpty()) {
                    printQueue.offer(printJobName);
                }
            }

            // Display the menu until the user chooses Exit
            do {

                System.out.println("\n===== Print Queue Management System =====");
                System.out.println("1. Add Print Job");
                System.out.println("2. Process Next Print Job");
                System.out.println("3. View Next Print Job");
                System.out.println("4. Search Print Job");
                System.out.println("5. Remove Print Job");
                System.out.println("6. Display All Print Jobs");
                System.out.println("7. Display Queue Statistics");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid choice. Please try again.");
                    scanner.next();
                    System.out.print("Enter your choice: ");
                }

                choice = scanner.nextInt();
                scanner.nextLine(); // Clear input buffer

                // Process the user's menu selection
                switch (choice) {

                    // Add a new print job
                    case 1:
                        System.out.print("Enter print job name: ");
                        printJobName = scanner.nextLine();
                        if (printJobName.isEmpty()) {
                            System.out.println("Print job name cannot be empty.");
                        } else {
                            printQueue.offer(printJobName);
                            System.out.println("Print job added successfully.");
                        }
                        break;

                    // Process the next print job
                    case 2:
                        if (printQueue.isEmpty()) {
                            System.out.println("No print jobs in the queue.");
                        } else {
                            String processedJob = printQueue.poll();
                            System.out.println("Processed print job: " + processedJob);
                        }
                        break;

                    // View the next print job
                    case 3:
                        if (printQueue.isEmpty()) {
                            System.out.println("No print jobs in the queue.");
                        } else {
                            System.out.println("Next print job: " + printQueue.peek());
                        }
                        break;

                    // Search for a print job
                    case 4:
                        System.out.print("Enter print job name to search: ");
                        printJobName = scanner.nextLine();

                        if (printJobName.isEmpty()) {
                            System.out.println("Print job not found.");
                        } else if (printQueue.contains(printJobName)) {
                            System.out.println("Print job found.");
                        } else {
                            System.out.println("Print job not found.");
                        }
                        break;

                    // Remove a specific print job
                    case 5:
                        System.out.print("Enter print job name to remove: ");
                        printJobName = scanner.nextLine();

                        if (printQueue.remove(printJobName)) {
                            System.out.println("Print job removed successfully.");
                        } else {
                            System.out.println("Print job not found.");
                        }
                        break;

                    // Display all print jobs
                    case 6:
                        if (printQueue.isEmpty()) {
                            System.out.println("No print jobs in the queue.");
                        } else {
                            System.out.println("Print Jobs:");
                            for (String job : printQueue) {
                                System.out.println(job);
                            }
                        }
                        break;

                    // Display queue statistics
                    case 7:
                        System.out.println("\n----- Queue Statistics -----");
                        System.out.println("Total number of print jobs: " + printQueue.size());

                        if (printQueue.isEmpty()) {
                            System.out.println("Next print job: None");
                        } else {
                            System.out.println("Next print job: " + printQueue.peek());
                        }

                        System.out.println("Queue is empty: " + printQueue.isEmpty());
                        break;

                    // Exit the program
                    case 8:
                        System.out.println("Exiting program...");
                        break;

                    // Invalid menu option
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 8);
        }

        // Close the Scanner
        scanner.close();
    }
}