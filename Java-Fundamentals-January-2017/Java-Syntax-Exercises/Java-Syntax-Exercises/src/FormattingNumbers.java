import java.util.Scanner;

public class FormattingNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();

        System.out.printf("|%-10s", Integer.toHexString(num1).toUpperCase());

        System.out.print("|" +
                String.format("%1$" + 10  + "s", Integer.toBinaryString(num1)).replace(' ', '0'));
        System.out.printf("|%10.2f", num2);
        System.out.printf("|%-10.3f", num3);
        System.out.println("|");
    }
}
