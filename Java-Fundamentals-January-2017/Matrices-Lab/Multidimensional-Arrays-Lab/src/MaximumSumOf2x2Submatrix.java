import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimension = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixDimension[0];
        int columns = matrixDimension[1];

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {

            int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < columns; col++) {

                matrix[row][col] = numbers[col];
            }
        }

        // Get max sum of submatrix
        int maxSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;

        for (int row = 0; row < rows - 1; row++) {

            for (int col = 0; col < columns - 1; col++) {

                int firstRowNum1 = matrix[row][col];
                int firstRowNum2 = matrix[row][col + 1];
                int secondRowNum1 = matrix[row + 1][col];
                int secondRowNum2 = matrix[row + 1][col + 1];

                int sum = firstRowNum1 + firstRowNum2 + secondRowNum1 + secondRowNum2;

                if (sum > maxSum) {

                    resultRow = row;
                    resultCol = col;
                    maxSum = sum;
                }
            }
        }

        System.out.printf("%d ", matrix[resultRow][resultCol]);
        System.out.printf("%d \n", matrix[resultRow][resultCol + 1]);
        System.out.printf("%d ", matrix[resultRow + 1][resultCol]);
        System.out.printf("%d \n", matrix[resultRow + 1][resultCol + 1]);
        System.out.println(maxSum);
    }
}
