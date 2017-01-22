import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split(" ");
        int n = Integer.valueOf(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, children);

        int cycle = 1;

        while (queue.size() > 1) {

            for (int i = 1; i < n; i++) {

                String currChild = queue.poll();
                queue.add(currChild);
            }

                if (!isPrime(cycle)) {

                    System.out.println("Removed " + queue.poll());
                }else {

                    System.out.println("Prime " + queue.peek());
                }

                cycle++;
            }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {

        if (cycle < 2) {

            return false;
        }

        for (int i = 2; i <= Math.sqrt(cycle); i++) {

            if (cycle % i == 0) {

                return false;
            }
        }

        return true;
    }
}
