import java.util.Scanner;

public class FromBaseSevenToDecimal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String baseSevenNum = scanner.nextLine();
        int base = 7;
        int decimalRepresentation = 0;

        int exponent = 0;

        for (int i = baseSevenNum.length() - 1; i >= 0; i--) {

            String currentSymbol = String.valueOf(baseSevenNum.charAt(i));
            decimalRepresentation += (Integer.valueOf(currentSymbol) * Math.pow(base, exponent));
            exponent++;
        }

        System.out.println(decimalRepresentation);
    }
}
