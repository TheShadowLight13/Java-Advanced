import java.util.Arrays;
import java.util.Scanner;

public class FirstOddOrEvenElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] commands = scanner.nextLine().split(" ");
        int numberOfElements = Integer.valueOf(commands[1]);
        String numbersType = commands[2];

        for (int i = 0, counter = numberOfElements; i < numbers.length && counter > 0; i++) {

            if (numbersType.equals("odd") && numbers[i] % 2 != 0) {

                System.out.print(numbers[i] + " ");
                counter--;
            }else if (numbersType.equals("even") && numbers[i] % 2 == 0){

                System.out.print(numbers[i] + " ");
                counter--;
            }
        }
    }
}
