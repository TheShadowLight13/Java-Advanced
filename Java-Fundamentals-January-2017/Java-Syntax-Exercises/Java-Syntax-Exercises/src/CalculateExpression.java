import java.util.Scanner;

public class CalculateExpression {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();

        double firstFormula =
                Math.pow((Math.pow(num1, 2) + Math.pow(num2, 2)) / ((Math.pow(num1, 2) - Math.pow(num2, 2)))
                        , (num1 + num2 + num3) / Math.sqrt(num3));

        double secondFormula =
                Math.pow((Math.pow(num1, 2) + Math.pow(num2, 2) - Math.pow(num3, 3)), (num1 - num2));

        double numsAverage = (num1 + num2 + num3) / 3.0;
        double formulasAverage = (firstFormula + secondFormula) / 2.0;
        double thirdFormula = Math.abs(numsAverage - formulasAverage);

        System.out.printf("F1 result: %.2f; ", firstFormula);
        System.out.printf("F2 result: %.2f; ", secondFormula);
        System.out.printf("Diff: %.2f", thirdFormula);
    }
}
