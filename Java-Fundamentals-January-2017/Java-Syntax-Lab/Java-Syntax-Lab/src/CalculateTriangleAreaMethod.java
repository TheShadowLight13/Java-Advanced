import java.util.Locale;
import java.util.Scanner;

public class CalculateTriangleAreaMethod {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double triangleArea = getTriangleArea(base, height);
        System.out.printf("Area = %.2f", triangleArea);

    }

    private static double getTriangleArea(double base, double height) {

        double area = (base * height) / 2;
        return area;
    }
}
