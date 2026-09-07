import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StudentRegistrationManager {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create Queue to store waiting students
        Queue<String> registrationQueue = new LinkedList<>();

        // Create Stack to store completed registrations
        Stack<String> registrationStack = new Stack<>();

        // Declare variables
        int numberOfStudents;
        int choice;
        String studentName;

        // Ask the user for the number of students
        System.out.print("Enter the number of students waiting for registration: ");
        numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        // Check if the number of students is valid
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {

            // Read student names and add them to the queue
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.print("Enter student " + i + " name: ");
                studentName = scanner.nextLine();
                registrationQueue.add(studentName);
            }

            // Display the menu until the user chooses Exit
            do {

                System.out.println("\n===== Student Registration System =====");
                System.out.println("1. Add Student to Queue");
                System.out.println("2. Process Student Registration");
                System.out.println("3. View Next Student");
                System.out.println("4. Undo Last Registration");
                System.out.println("5. Search Student");
                System.out.println("6. Display Waiting Students");
                System.out.println("7. Display Registered Students");
                System.out.println("8. Display Statistics");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear input buffer

                // Process the user's menu selection
                switch (choice) {

                    // Add a student to the queue
                    case 1:
                        System.out.print("Enter student name: ");
                        studentName = scanner.nextLine();
                        registrationQueue.add(studentName);
                        System.out.println("Student added to registration queue successfully.");
                        break;

                    // Process student registration
                    case 2:
                        if (registrationQueue.isEmpty()) {
                            System.out.println("No students waiting for registration.");
                        } else {
                            String registeredStudent = registrationQueue.remove();
                            registrationStack.push(registeredStudent);
                            System.out.println("Student registration completed.");
                            System.out.println("Registered Student: " + registeredStudent);
                        }
                        break;

                    // View next student
                    case 3:
                        if (registrationQueue.isEmpty()) {
                            System.out.println("No students in the queue.");
                        } else {
                            System.out.println("Next Student: " + registrationQueue.element());
                        }
                        break;

                    // Undo last registration
                    case 4:
                        if (registrationStack.isEmpty()) {
                            System.out.println("No registrations to undo.");
                        } else {
                            String removedStudent = registrationStack.pop();
                            System.out.println("Last registration removed: " + removedStudent);
                        }
                        break;

                    // Search for a student
                    case 5:
                        System.out.print("Enter student name to search: ");
                        studentName = scanner.nextLine();

                        if (registrationQueue.contains(studentName)) {
                            System.out.println("Student is waiting for registration.");
                        } else if (registrationStack.search(studentName) != -1) {
                            System.out.println("Student is already registered.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    // Display waiting students
                    case 6:
                        if (registrationQueue.isEmpty()) {
                            System.out.println("No waiting students.");
                        } else {
                            System.out.println("Waiting Students:");
                            for (String student : registrationQueue) {
                                System.out.println(student);
                            }
                        }
                        break;

                    // Display registered students
                    case 7:
                        if (registrationStack.isEmpty()) {
                            System.out.println("No registered students.");
                        } else {
                            System.out.println("Registered Students:");
                            for (String student : registrationStack) {
                                System.out.println(student);
                            }
                        }
                        break;

                    // Display statistics
                    case 8:
                        System.out.println("\n----- Registration Statistics -----");
                        System.out.println("Total waiting students: " + registrationQueue.size());
                        System.out.println("Total registered students: " + registrationStack.size());

                        if (registrationQueue.isEmpty()) {
                            System.out.println("Next student waiting: None");
                        } else {
                            System.out.println("Next student waiting: " + registrationQueue.element());
                        }

                        if (registrationStack.isEmpty()) {
                            System.out.println("Last registered student: None");
                        } else {
                            System.out.println("Last registered student: " + registrationStack.peek());
                        }

                        System.out.println("Queue is empty: " + registrationQueue.isEmpty());
                        System.out.println("Stack is empty: " + registrationStack.isEmpty());
                        break;

                    // Exit the program
                    case 9:
                        System.out.println("Exiting program...");
                        break;

                    // Invalid menu option
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 9);
        }

        // Close the Scanner
        scanner.close();
    }
}-