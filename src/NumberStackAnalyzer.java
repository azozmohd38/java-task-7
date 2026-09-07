import java.util.Scanner;
import java.util.Stack;

public class NumberStackAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create a stack to store integer values
        Stack<Integer> numberStack = new Stack<>();

        // Declare variables
        int numberOfValues;
        int choice;

        // Ask the user for the number of values
        System.out.print("Enter the number of values: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid number of values.");
            scanner.next();
            System.out.print("Enter the number of values: ");
        }

        numberOfValues = scanner.nextInt();

        // Check if the number of values is valid
        if (numberOfValues <= 0) {
            System.out.println("Invalid number of values.");
        } else {

            // Read integers and push them into the stack
            for (int i = 1; i <= numberOfValues; i++) {
                System.out.print("Enter number " + i + ": ");
                int value = scanner.nextInt();
                numberStack.push(value);
            }

            // Display menu until the user chooses Exit
            do {

                System.out.println("\n===== Number Stack Analyzer =====");
                System.out.println("1. Add Number");
                System.out.println("2. Remove Top Number");
                System.out.println("3. View Top Number");
                System.out.println("4. Display All Numbers");
                System.out.println("5. Analyze Numbers");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                // Process the user's choice
                switch (choice) {

                    // Add a number to the stack
                    case 1:
                        System.out.print("Enter a number: ");
                        int newNumber = scanner.nextInt();
                        numberStack.push(newNumber);
                        System.out.println("Number added successfully.");
                        break;

                    // Remove the top number
                    case 2:
                        if (numberStack.isEmpty()) {
                            System.out.println("Stack is empty.");
                        } else {
                            int removedNumber = numberStack.pop();
                            System.out.println("Removed number: " + removedNumber);
                        }
                        break;

                    // View the top number
                    case 3:
                        if (numberStack.isEmpty()) {
                            System.out.println("Stack is empty.");
                        } else {
                            System.out.println("Top number: " + numberStack.peek());
                        }
                        break;

                    // Display all numbers
                    case 4:
                        if (numberStack.isEmpty()) {
                            System.out.println("Stack is empty.");
                        } else {
                            System.out.println("Numbers in the stack:");
                            for (int number : numberStack) {
                                System.out.println(number);
                            }
                        }
                        break;

                    // Analyze the numbers
                    case 5:
                        if (numberStack.isEmpty()) {
                            System.out.println("Stack is empty.");
                        } else {

                            int sum = 0;
                            int largest = numberStack.get(0);
                            int smallest = numberStack.get(0);
                            int evenCount = 0;
                            int oddCount = 0;
                            int positiveCount = 0;
                            int negativeCount = 0;
                            int zeroCount = 0;

                            // Analyze every number in the stack
                            for (int number : numberStack) {

                                sum += number;

                                if (number > largest) {
                                    largest = number;
                                }

                                if (number < smallest) {
                                    smallest = number;
                                }

                                if (number % 2 == 0) {
                                    evenCount++;
                                } else {
                                    oddCount++;
                                }

                                if (number > 0) {
                                    positiveCount++;
                                } else if (number < 0) {
                                    negativeCount++;
                                } else {
                                    zeroCount++;
                                }
                            }

                            double average = (double) sum / numberStack.size();

                            // Display analysis results
                            System.out.println("\n----- Analysis Results -----");
                            System.out.println("Total number of elements: " + numberStack.size());
                            System.out.println("Sum of all numbers: " + sum);
                            System.out.println("Average of all numbers: " + average);
                            System.out.println("Largest number: " + largest);
                            System.out.println("Smallest number: " + smallest);
                            System.out.println("Total even numbers: " + evenCount);
                            System.out.println("Total odd numbers: " + oddCount);
                            System.out.println("Total positive numbers: " + positiveCount);
                            System.out.println("Total negative numbers: " + negativeCount);
                            System.out.println("Total zeros: " + zeroCount);
                        }
                        break;

                    // Exit the program
                    case 6:
                        System.out.println("Exiting program...");
                        break;

                    // Invalid menu option
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 6);
        }

        // Close the scanner
        scanner.close();
    }
}