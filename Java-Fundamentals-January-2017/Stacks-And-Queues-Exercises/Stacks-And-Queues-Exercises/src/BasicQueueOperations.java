import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int numbersToPush = Integer.valueOf(tokens[0]);
        int numbersToPop = Integer.valueOf(tokens[1]);
        int checkNumber = Integer.valueOf(tokens[2]);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // Push numbers into the queue
        for (int i = 0; i < numbersToPush; i++) {

            queue.add(numbers[i]);
        }

        // Remove numbers from queue
        for (int i = 0; i < numbersToPop; i++) {

            queue.poll();
        }

        boolean isNumberExist = queue.contains(checkNumber);

        if (isNumberExist) {

            System.out.println("true");
        }else {

            int minNumber = getMinNumber(queue);
            System.out.println(minNumber);
        }
    }

    private static int getMinNumber(ArrayDeque<Integer> queue) {

        int minNumber = queue.size() > 0 ? Integer.MAX_VALUE : 0;

        for (Integer number : queue) {

            if (number < minNumber) {

                minNumber = number;
            }
        }

        return minNumber;
    }
}
