import java.util.Arrays;
import java.util.Scanner;

public class OddAndEvenPairs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (numbers.length % 2 != 0) {

            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < numbers.length - 1; i++) {

            int firstNum = numbers[i];
            int secondNum = numbers[i + 1];

            if (firstNum % 2 == 0 && secondNum % 2 == 0) {

                System.out.printf("%d, %d -> both are even\n", firstNum, secondNum);
            }else if (firstNum % 2 != 0 && secondNum % 2 != 0) {

                System.out.printf("%d, %d -> both are odd\n", firstNum, secondNum);
            }else {

                System.out.printf("%d, %d -> different\n", firstNum, secondNum);
            }
            i++;
        }
    }
}
