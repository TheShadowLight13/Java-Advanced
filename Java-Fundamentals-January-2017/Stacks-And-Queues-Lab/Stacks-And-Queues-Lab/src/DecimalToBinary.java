import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer number = Integer.valueOf(scanner.nextLine());

        ArrayDeque<Integer> binaryRepresentation = new ArrayDeque<>();

        if (number == 0) {

            binaryRepresentation.push(0);
        }

        while (number > 0) {

            int divider = number % 2;
            binaryRepresentation.push(divider);
            number /= 2;
        }

        while (binaryRepresentation.size() > 0) {

            System.out.printf("%d", binaryRepresentation.pop());
        }
    }
}
