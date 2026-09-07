import java.util.Scanner;
import java.util.Stack;

public class BookStackManager {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Create Stack to store book titles
        Stack<String> bookStack = new Stack<>();

        // Declare variables
        int numberOfBooks;
        int choice;
        String bookTitle;
        int position;

        // Ask user for the number of books
        System.out.print("Enter the number of books: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid number of books.");
            scanner.next();
            System.out.print("Enter the number of books: ");
        }

        numberOfBooks = scanner.nextInt();
        scanner.nextLine();

        // Validate number of books
        if (numberOfBooks <= 0) {
            System.out.println("Invalid number of books.");
        } else {

            // Read book titles and push them into the stack
            for (int i = 1; i <= numberOfBooks; i++) {
                System.out.print("Enter book title " + i + ": ");
                bookTitle = scanner.nextLine().trim();
                if (!bookTitle.isEmpty()) {
                    bookStack.push(bookTitle);
                }
            }

            // Display menu until user chooses Exit
            do {

                System.out.println("\n========== Book Stack Menu ==========");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Top Book");
                System.out.println("3. View Top Book");
                System.out.println("4. Search Book");
                System.out.println("5. Display All Books");
                System.out.println("6. Display Stack Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid choice. Please try again.");
                    scanner.next();
                    System.out.print("Enter your choice: ");
                }

                choice = scanner.nextInt();
                scanner.nextLine();

                // Process user's choice
                switch (choice) {

                    // Add Book
                    case 1:
                        System.out.print("Enter new book title: ");
                        bookTitle = scanner.nextLine().trim();
                        if (bookTitle.isEmpty()) {
                            System.out.println("Book title cannot be empty.");
                        } else {
                            bookStack.push(bookTitle);
                            System.out.println("Book added successfully.");
                        }
                        break;

                    // Remove Top Book
                    case 2:
                        if (bookStack.isEmpty()) {
                            System.out.println("No books available.");
                        } else {
                            System.out.println("Removed Book: " + bookStack.pop());
                        }
                        break;

                    // View Top Book
                    case 3:
                        if (bookStack.isEmpty()) {
                            System.out.println("No books available.");
                        } else {
                            System.out.println("Top Book: " + bookStack.peek());
                        }
                        break;

                    // Search Book
                    case 4:
                        System.out.print("Enter book title to search: ");
                        bookTitle = scanner.nextLine().trim();

                        position = bookStack.search(bookTitle);

                        if (position == -1) {
                            System.out.println("Book not found.");
                        } else {
                            System.out.println("Book found at position " + position + " from the top.");
                        }
                        break;

                    // Display All Books
                    case 5:
                        if (bookStack.isEmpty()) {
                            System.out.println("No books available.");
                        } else {
                            System.out.println("Books in Stack:");
                            for (int i = bookStack.size() - 1; i >= 0; i--) {
                                System.out.println(bookStack.get(i));
                            }
                        }
                        break;

                    // Display Stack Statistics
                    case 6:
                        System.out.println("\n----- Stack Statistics -----");
                        System.out.println("Total number of books: " + bookStack.size());

                        if (bookStack.isEmpty()) {
                            System.out.println("Top Book: No books available.");
                        } else {
                            System.out.println("Top Book: " + bookStack.peek());
                        }

                        System.out.println("Is Stack Empty? " + bookStack.isEmpty());
                        System.out.println("Stack Size: " + bookStack.size());
                        break;

                    // Exit
                    case 7:
                        System.out.println("Program terminated.");
                        break;

                    // Invalid choice
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 7);
        }

        scanner.close();
    }
}