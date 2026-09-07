
import java.util.Scanner;

public class StudentNameManager {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Main variables
        int numberOfStudents;
        int choice;
        int studentCount;
        String studentName;
        String searchName;
        String oldName;
        String newName;
        String firstName;
        String secondName;
        boolean found;

        // Ask user for number of students
        System.out.print("Enter number of students: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid number of students.");
            input.next();
            System.out.print("Enter number of students: ");
        }

        numberOfStudents = input.nextInt();
        input.nextLine();

        // Validate number of students
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {

            // Create String array with extra space for adding new students
            String[] studentNames = new String[numberOfStudents + 10];

            // Store current number of students
            studentCount = numberOfStudents;

            // Read student names
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter student name " + (i + 1) + ": ");
                studentNames[i] = input.nextLine().trim();
            }

            // Display menu until user exits
            do {

                System.out.println("\n========== STUDENT NAME MANAGEMENT ==========");
                System.out.println("1. Add Student Name");
                System.out.println("2. Search Student Name");
                System.out.println("3. Update Student Name");
                System.out.println("4. Display All Student Names");
                System.out.println("5. Analyze Names");
                System.out.println("6. Compare Two Names");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                while (!input.hasNextInt()) {
                    System.out.println("Invalid menu choice.");
                    input.next();
                    System.out.print("Enter your choice: ");
                }

                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    // Add Student Name
                    case 1:

                        System.out.print("Enter new student name: ");
                        studentName = input.nextLine().trim();

                        if (studentName.isEmpty()) {
                            System.out.println("Student name cannot be empty.");
                            break;
                        }

                        found = false;

                        for (int i = 0; i < studentCount; i++) {
                            if (studentNames[i].equals(studentName)) {
                                found = true;
                                break;
                            }
                        }

                        if (found) {
                            System.out.println("Student name already exists.");
                        } else if (studentCount >= studentNames.length) {
                            System.out.println("Student list is full.");
                        } else {
                            studentNames[studentCount] = studentName;
                            studentCount++;
                            System.out.println("Student name added successfully.");
                        }

                        break;

                    // Search Student Name
                    case 2:

                        System.out.print("Enter student name to search: ");
                        searchName = input.nextLine().trim();

                        found = false;

                        for (int i = 0; i < studentCount; i++) {
                            if (studentNames[i].equals(searchName)) {
                                found = true;
                                break;
                            }
                        }

                        if (found) {
                            System.out.println("Student found.");
                        } else {
                            System.out.println("Student not found.");
                        }

                        break;

                    // Update Student Name
                    case 3:

                        System.out.print("Enter existing student name: ");
                        oldName = input.nextLine().trim();

                        System.out.print("Enter new student name: ");
                        newName = input.nextLine().trim();

                        if (newName.isEmpty()) {
                            System.out.println("Student name cannot be empty.");
                            break;
                        }

                        found = false;

                        boolean newNameExists = false;

                        for (int i = 0; i < studentCount; i++) {
                            if (studentNames[i].equals(newName)) {
                                newNameExists = true;
                                break;
                            }
                        }

                        if (newNameExists && !oldName.equals(newName)) {
                            System.out.println("Student name already exists.");
                            break;
                        }

                        for (int i = 0; i < studentCount; i++) {
                            if (studentNames[i].equals(oldName)) {
                                studentNames[i] = newName;
                                found = true;
                                break;
                            }
                        }

                        if (found) {
                            System.out.println("Student name updated successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }

                        break;

                    // Display All Student Names
                    case 4:

                        System.out.println("\nStudent Names:");

                        for (int i = 0; i < studentCount; i++) {
                            System.out.println((i + 1) + ". " + studentNames[i]);
                        }

                        break;

                    // Analyze Names
                    case 5:

                        String longestName = studentNames[0];
                        String shortestName = studentNames[0];
                        int totalCharacters = 0;
                        int startsWithA = 0;
                        int endsWithA = 0;

                        for (int i = 0; i < studentCount; i++) {

                            if (studentNames[i].length() > longestName.length()) {
                                longestName = studentNames[i];
                            }

                            if (studentNames[i].length() < shortestName.length()) {
                                shortestName = studentNames[i];
                            }

                            totalCharacters += studentNames[i].length();

                            if (studentNames[i].toUpperCase().startsWith("A")) {
                                startsWithA++;
                            }

                            if (studentNames[i].toLowerCase().endsWith("a")) {
                                endsWithA++;
                            }
                        }

                        double averageLength = studentCount == 0
                                ? 0
                                : (double) totalCharacters / studentCount;

                        System.out.println("\n===== Name Statistics =====");
                        System.out.println("Total Students: " + studentCount);
                        System.out.println("Longest Name: " + longestName);
                        System.out.println("Shortest Name: " + shortestName);
                        System.out.println("Total Characters: " + totalCharacters);
                        System.out.printf("Average Name Length: %.2f%n", averageLength);
                        System.out.println("Names Starting with A: " + startsWithA);
                        System.out.println("Names Ending with a: " + endsWithA);

                        // Demonstrate required String methods
                        System.out.println("\nExample String Operations:");
                        System.out.println("Uppercase of first name: " + studentNames[0].toUpperCase());
                        System.out.println("Lowercase of first name: " + studentNames[0].toLowerCase());
                        System.out.println("First Character: " + studentNames[0].charAt(0));

                        if (studentNames[0].length() >= 3) {
                            System.out.println("Substring (0-3): " + studentNames[0].substring(0, 3));
                        }

                        break;

                    // Compare Two Names
                    case 6:

                        System.out.print("Enter first name: ");
                        firstName = input.nextLine().trim();

                        System.out.print("Enter second name: ");
                        secondName = input.nextLine().trim();

                        System.out.println("equals(): " + firstName.equals(secondName));
                        System.out.println("equalsIgnoreCase(): " + firstName.equalsIgnoreCase(secondName));
                        System.out.println("compareTo(): " + firstName.compareTo(secondName));

                        break;

                    // Exit
                    case 7:

                        System.out.println("Program terminated.");
                        break;

                    // Invalid choice
                    default:

                        System.out.println("Invalid menu choice.");

                }

            } while (choice != 7);
        }

        // Close Scanner
        input.close();
    }
}