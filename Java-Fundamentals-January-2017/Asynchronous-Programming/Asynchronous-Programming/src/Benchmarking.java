import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class Benchmarking {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int to = Integer.valueOf(scanner.nextLine());

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i <= to; i++) {
            numbers.add(i);
        }

        ExecutorService es = Executors.newFixedThreadPool(4);
        Future[] results = new Future[numbers.size()];

        long start = System.nanoTime();

        for (int i = 0; i < numbers.size(); i++) {

            Integer number = numbers.get(i);
            Future<Boolean> future = es.submit(() -> isPrime(number));
            results[i] = future;
        }

        es.awaitTermination(100L, TimeUnit.MILLISECONDS);
        long end = System.nanoTime() - start;
        System.out.printf("Execution time: " + end);
        es.shutdown();

    }

    private static boolean isPrime(Integer number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(number); i++) {
            if (number % 2 == 0) {
                return false;
            }
        }

        return true;
    }
}
