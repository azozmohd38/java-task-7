
import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variables
        String password;
        int choice;
        int length;
        int uppercaseCount;
        int lowercaseCount;
        int digitCount;
        int specialCount;
        String strength;

        // Prompt user to enter password
        System.out.print("Enter a password: ");
        password = input.nextLine().trim();

        // Validate password
        if (password.length() <= 0) {
            System.out.println("Invalid password.");
        } else {

            // Display initial information
            System.out.println("Password accepted.");
            System.out.println("Password Length: " + password.length());
        }

        // Display menu until user exits
        do {

            System.out.println("\n========== PASSWORD STRENGTH CHECKER ==========");
            System.out.println("1. Enter Password");
            System.out.println("2. Check Password Length");
            System.out.println("3. Analyze Password Characters");
            System.out.println("4. Check Password Strength");
            System.out.println("5. Convert Password Format");
            System.out.println("6. Display Password Report");
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

                // Enter Password
                case 1:

                    System.out.print("Enter new password: ");
                    password = input.nextLine().trim();

                    if (password.isEmpty()) {
                        System.out.println("Invalid password.");
                    } else {
                        System.out.println("Password saved successfully.");
                    }
                    break;

                // Check Password Length
                case 2:

                    length = password.length();
                    System.out.println("Password Length: " + length);

                    if (length < 8) {
                        System.out.println("Password is too short.");
                    } else {
                        System.out.println("Password length is acceptable.");
                    }

                    break;

                // Analyze Password Characters
                case 3:
                    uppercaseCount = 0;
                    lowercaseCount = 0;
                    digitCount = 0;
                    specialCount = 0;

                    // Count character types
                    for (int i = 0; i < password.length(); i++) {

                        char ch = password.charAt(i);

                        if (Character.isUpperCase(ch)) {
                            uppercaseCount++;
                        } else if (Character.isLowerCase(ch)) {
                            lowercaseCount++;
                        } else if (Character.isDigit(ch)) {
                            digitCount++;
                        } else {
                            specialCount++;
                        }
                    }

                    System.out.println("Uppercase Letters: " + uppercaseCount);
                    System.out.println("Lowercase Letters: " + lowercaseCount);
                    System.out.println("Digits: " + digitCount);
                    System.out.println("Special Characters: " + specialCount);

                    break;

                // Check Password Strength
                case 4:

                    uppercaseCount = 0;
                    lowercaseCount = 0;
                    digitCount = 0;
                    specialCount = 0;

                    for (int i = 0; i < password.length(); i++) {

                        char ch = password.charAt(i);

                        if (Character.isUpperCase(ch)) {
                            uppercaseCount++;
                        } else if (Character.isLowerCase(ch)) {
                            lowercaseCount++;
                        } else if (Character.isDigit(ch)) {
                            digitCount++;
                        } else {
                            specialCount++;
                        }
                    }

                    if (password.length() >= 8 &&
                            uppercaseCount > 0 &&
                            lowercaseCount > 0 &&
                            digitCount > 0 &&
                            specialCount > 0) {

                        strength = "Strong Password";

                    } else if (password.length() >= 6 &&
                            uppercaseCount > 0 &&
                            lowercaseCount > 0 &&
                            digitCount > 0) {

                        strength = "Medium Password";

                    } else {

                        strength = "Weak Password";
                    }

                    System.out.println("Password Strength: " + strength);

                    break;

                // Convert Password Format
                case 5:

                    System.out.println("Uppercase: " + password.toUpperCase());
                    System.out.println("Lowercase: " + password.toLowerCase());

                    break;

                // Display Password Report
                case 6:

                    uppercaseCount = 0;
                    lowercaseCount = 0;
                    digitCount = 0;
                    specialCount = 0;

                    for (int i = 0; i < password.length(); i++) {

                        char ch = password.charAt(i);

                        if (Character.isUpperCase(ch))
                            uppercaseCount++;
                        else if (Character.isLowerCase(ch))
                            lowercaseCount++;
                        else if (Character.isDigit(ch))
                            digitCount++;
                        else
                            specialCount++;
                    }

                    if (password.length() >= 8 &&
                            uppercaseCount > 0 &&
                            lowercaseCount > 0 &&
                            digitCount > 0 &&
                            specialCount > 0) {

                        strength = "Strong Password";

                    } else if (password.length() >= 6 &&
                            uppercaseCount > 0 &&
                            lowercaseCount > 0 &&
                            digitCount > 0) {

                        strength = "Medium Password";

                    } else {

                        strength = "Weak Password";
                    }

                    System.out.println("\n========== PASSWORD REPORT ==========");
                    System.out.println("Password Length: " + password.length());
                    System.out.println("First Character: " + password.charAt(0));
                    System.out.println("Last Character: " + password.charAt(password.length() - 1));
                    System.out.println("Uppercase Letters: " + uppercaseCount);
                    System.out.println("Lowercase Letters: " + lowercaseCount);
                    System.out.println("Digits: " + digitCount);
                    System.out.println("Special Characters: " + specialCount);
                    System.out.println("Password Strength: " + strength);

                    // Demonstrate required String methods
                    System.out.println("\nAdditional String Operations:");
                    System.out.println("Contains '@' : " + password.contains("@"));
                    System.out.println("Starts with 'A' : " + password.startsWith("A"));
                    System.out.println("Ends with '!' : " + password.endsWith("!"));
                    System.out.println("Equals 'Password123' : " + password.equals("Password123"));

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

        // Close Scanner
        input.close();
    }
}
