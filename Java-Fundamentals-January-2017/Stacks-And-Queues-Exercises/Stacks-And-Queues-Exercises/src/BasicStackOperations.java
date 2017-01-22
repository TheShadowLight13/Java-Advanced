import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        int countOfNumbers = Integer.valueOf(tokens[0]);
        int numbersToPop = Integer.valueOf(tokens[1]);
        int numberToCheck = Integer.valueOf(tokens[2]);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < countOfNumbers; i++) {

            stack.push(numbers[i]);
        }

        for (int i = 0; i < numbersToPop; i++) {

            if (stack.size() > 0) {

                stack.pop();
            }else {

                break;
            }
        }

        boolean isNumberExist = stack.contains(numberToCheck);
        if (isNumberExist) {

            System.out.println(isNumberExist);
        }else {

            int minNumber = getMinNumber(stack);
            System.out.println(minNumber);
        }

    }

    private static int getMinNumber(ArrayDeque<Integer> stack) {

        int minNumber = stack.size() > 0 ? Integer.MAX_VALUE : 0;

        for (Integer number : stack) {

            if (number < minNumber) {

                minNumber = number;
            }
        }

        return minNumber;
    }
}
