import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDimension = scanner.nextLine().split(" ");
        int rows = Integer.valueOf(matrixDimension[0]);
        int columns = Integer.valueOf(matrixDimension[1]);

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {

            int[] numbersForCol = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < columns; col++) {

                matrix[row][col] = numbersForCol[col];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < rows - 2; row++) {

            for (int col = 0; col < columns - 2; col++) {

                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.printf("Sum = %d\n", maxSum);
        for (int row = startRow; row < startRow + 3; row++) {

            for (int col = startCol; col < startCol + 3; col++) {

                System.out.printf("%d ", matrix[row][col]);
            }

            System.out.println();
        }

    }
}
