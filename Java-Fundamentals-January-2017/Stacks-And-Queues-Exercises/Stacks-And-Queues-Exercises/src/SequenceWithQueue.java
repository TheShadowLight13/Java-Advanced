import java.util.ArrayDeque;
import java.util.Scanner;

public class SequenceWithQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = Long.valueOf(scanner.nextLine());
        int numbersCount = 50;

        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.addFirst(n);

        for (int i = 0; i < numbersCount; i++) {

            long currentNum = queue.removeFirst();

            System.out.printf("%s ", currentNum);

            long s1 = currentNum + 1;
            long s2 = (2 * currentNum) + 1;
            long s3 = currentNum + 2;

            queue.addLast(s1);
            queue.addLast(s2);
            queue.addLast(s3);
        }
    }
}
