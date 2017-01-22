import java.util.Scanner;

public class FromDecimalToBaseSeven {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decimalNumber = scanner.nextInt();
        int base = 7;

        StringBuilder result = new StringBuilder();

        while (decimalNumber > 0) {

            result.append(decimalNumber % base);
            decimalNumber = decimalNumber / base;
        }

        result.reverse();
        System.out.println(result);
    }
}
