import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimension = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixDimension[0];
        int columns = matrixDimension[1];

        int[][] matrix = new int[rows][columns];

        int totalSum = 0;

        for (int row = 0; row < rows; row++) {

            int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < columns; col++) {

                matrix[row][col] = numbers[col];
                totalSum += numbers[col];
            }
        }

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(totalSum);
    }
}
