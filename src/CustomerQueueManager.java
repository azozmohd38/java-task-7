import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerQueueManager {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create a Queue using LinkedList to store customer names
        Queue<String> customerQueue = new LinkedList<>();

        // Declare variables
        int numberOfCustomers;
        int choice;
        String customerName;

        // Ask the user for the number of customers
        System.out.print("Enter the number of customers: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid number of customers.");
            scanner.next();
            System.out.print("Enter the number of customers: ");
        }

        numberOfCustomers = scanner.nextInt();
        scanner.nextLine();

        // Check if the number of customers is valid
        if (numberOfCustomers <= 0) {
            System.out.println("Invalid number of customers.");
        } else {

            // Read customer names and add them to the queue
            for (int i = 1; i <= numberOfCustomers; i++) {
                System.out.print("Enter customer " + i + " name: ");
                customerName = scanner.nextLine().trim();
                if (!customerName.isEmpty()) {
                    customerQueue.offer(customerName);
                }
            }

            // Display the menu until the user chooses Exit
            do {

                System.out.println("\n===== Customer Queue Management System =====");
                System.out.println("1. Add Customer");
                System.out.println("2. Serve Customer");
                System.out.println("3. View Next Customer");
                System.out.println("4. Search Customer");
                System.out.println("5. Display All Customers");
                System.out.println("6. Display Queue Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid choice. Please try again.");
                    scanner.next();
                    System.out.print("Enter your choice: ");
                }

                choice = scanner.nextInt();
                scanner.nextLine(); // Clear the input buffer

                // Process the user's menu selection
                switch (choice) {

                    // Add a customer
                    case 1:
                        System.out.print("Enter customer name: ");
                        customerName = scanner.nextLine();
                        if (customerName.isEmpty()) {
                            System.out.println("Customer name cannot be empty.");
                        } else {
                            customerQueue.offer(customerName);
                            System.out.println("Customer added successfully.");
                        }
                        break;

                    // Serve the first customer
                    case 2:
                        if (customerQueue.isEmpty()) {
                            System.out.println("No customers in the queue.");
                        } else {
                            String servedCustomer = customerQueue.poll();
                            System.out.println("Served customer: " + servedCustomer);
                        }
                        break;

                    // View the next customer
                    case 3:
                        if (customerQueue.isEmpty()) {
                            System.out.println("No customers in the queue.");
                        } else {
                            System.out.println("Next customer: " + customerQueue.peek());
                        }
                        break;

                    // Search for a customer
                    case 4:
                        System.out.print("Enter customer name to search: ");
                        customerName = scanner.nextLine();

                        if (customerQueue.contains(customerName)) {
                            System.out.println("Customer found in the queue.");
                        } else {
                            System.out.println("Customer not found.");
                        }
                        break;

                    // Display all customers
                    case 5:
                        if (customerQueue.isEmpty()) {
                            System.out.println("No customers in the queue.");
                        } else {
                            System.out.println("Customers in the queue:");
                            int position = 1;
                            for (String customer : customerQueue) {
                                System.out.println(position + ". " + customer);
                                position++;
                            }
                        }
                        break;

                    // Display queue statistics
                    case 6:
                        System.out.println("\n----- Queue Statistics -----");
                        System.out.println("Total number of customers: " + customerQueue.size());

                        if (customerQueue.isEmpty()) {
                            System.out.println("First customer: None");
                            System.out.println("Last customer: None");
                        } else {
                            System.out.println("First customer: " + customerQueue.peek());

                            // Find the last customer using a loop
                            String lastCustomer = "";
                            for (String customer : customerQueue) {
                                lastCustomer = customer;
                            }

                            System.out.println("Last customer: " + lastCustomer);
                        }

                        System.out.println("Queue is empty: " + customerQueue.isEmpty());
                        break;

                    // Exit the program
                    case 7:
                        System.out.println("Exiting program...");
                        break;

                    // Invalid menu choice
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 7);
        }

        // Close the Scanner
        scanner.close();
    }
}
