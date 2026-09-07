import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class HospitalPatientManager {

    static Scanner scanner = new Scanner(System.in);
    static Queue<String> waitingPatients = new LinkedList<>();
    static Stack<String> treatedPatients = new Stack<>();

    public static void main(String[] args) {
        startSystem();
        scanner.close();
    }

    public static void startSystem() {
        System.out.print("Enter the number of patients waiting: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid number of patients.");
            scanner.next();
            System.out.print("Enter the number of patients waiting: ");
        }

        int numberOfPatients = scanner.nextInt();
        scanner.nextLine();

        if (numberOfPatients <= 0) {
            System.out.println("Invalid number of patients.");
            return;
        }

        for (int i = 1; i <= numberOfPatients; i++) {
            System.out.print("Enter patient " + i + " name: ");
            String patientName = scanner.nextLine().trim();

            if (!patientName.isEmpty()) {
                waitingPatients.offer(patientName);
            }
        }

        runMenu();
    }

    public static void runMenu() {
        int choice;

        do {
            System.out.println("\n===== Hospital Patient Management =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Treat Patient");
            System.out.println("3. View Next Patient");
            System.out.println("4. Undo Last Treatment");
            System.out.println("5. Search Patient");
            System.out.println("6. Display Waiting Patients");
            System.out.println("7. Display Treated Patients");
            System.out.println("8. Display Hospital Statistics");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    treatPatient();
                    break;
                case 3:
                    viewNextPatient();
                    break;
                case 4:
                    undoLastTreatment();
                    break;
                case 5:
                    searchPatient();
                    break;
                case 6:
                    displayWaitingPatients();
                    break;
                case 7:
                    displayTreatedPatients();
                    break;
                case 8:
                    displayStatistics();
                    break;
                case 9:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }
}
