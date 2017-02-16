import java.util.ArrayList;
import java.util.Scanner;

public class ResponsiveUI {

    public static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        Runnable task = () -> primesInRange(10000000);
        Thread thread = new Thread(task);
        thread.start();

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("stop")) {

               thread.interrupt();
               break;
            }else {
                System.out.println("unknown command");
            }
        }

        thread.join();
        System.out.println("Calculated primes: " + primes.size());
    }

    public static void primesInRange(int number){

        for (int primeCandidate = 0; primeCandidate <= number; primeCandidate++) {

            if (isPrime(primeCandidate)) {
                primes.add(primeCandidate);
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted...");
                break;
            }
        }
    }

    public static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
