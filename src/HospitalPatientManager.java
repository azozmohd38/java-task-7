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
    }
}
