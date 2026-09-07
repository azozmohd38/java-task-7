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

    public static void displayStatistics() {
        System.out.println("\n----- Hospital Statistics -----");
        System.out.println("Total waiting patients: " + waitingPatients.size());
        System.out.println("Total treated patients: " + treatedPatients.size());
        System.out.println("Next patient waiting: " + (waitingPatients.isEmpty() ? "None" : waitingPatients.peek()));
        System.out.println("Last treated patient: " + (treatedPatients.isEmpty() ? "None" : treatedPatients.peek()));
        System.out.println("Queue is empty: " + waitingPatients.isEmpty());
        System.out.println("Stack is empty: " + treatedPatients.isEmpty());
    }

    public static void displayWaitingPatients() {
        if (waitingPatients.isEmpty()) {
            System.out.println("No waiting patients.");
        } else {
            System.out.println("Waiting Patients:");
            for (String patient : waitingPatients) {
                System.out.println(patient);
            }
        }
    }

    public static void displayTreatedPatients() {
        if (treatedPatients.isEmpty()) {
            System.out.println("No treated patients.");
        } else {
            System.out.println("Treated Patients:");
            for (int i = treatedPatients.size() - 1; i >= 0; i--) {
                System.out.println(treatedPatients.get(i));
            }
        }
    }

    public static void searchPatient() {
        System.out.print("Enter patient name to search: ");
        String patientName = scanner.nextLine().trim();

        if (waitingPatients.contains(patientName)) {
            System.out.println("Patient is waiting for treatment.");
        } else if (treatedPatients.search(patientName) != -1) {
            System.out.println("Patient treatment completed.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    public static void undoLastTreatment() {
        if (treatedPatients.isEmpty()) {
            System.out.println("No completed treatments available.");
            return;
        }

        String patient = treatedPatients.pop();
        System.out.println("Treatment undone for: " + patient);
    }

    public static void viewNextPatient() {
        if (waitingPatients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            System.out.println("Next Patient: " + waitingPatients.peek());
        }
    }

    public static void treatPatient() {
        if (waitingPatients.isEmpty()) {
            System.out.println("No patients waiting for treatment.");
            return;
        }

        String patient = waitingPatients.poll();
        treatedPatients.push(patient);
        System.out.println("Patient treatment completed successfully.");
        System.out.println("Treated Patient: " + patient);
    }

    public static void addPatient() {
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine().trim();

        if (patientName.isEmpty()) {
            System.out.println("Patient name cannot be empty.");
            return;
        }

        waitingPatients.offer(patientName);
        System.out.println("Patient added successfully.");
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
