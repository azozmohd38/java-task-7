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
    }
}
