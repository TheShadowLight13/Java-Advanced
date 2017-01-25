import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixDimension = Integer.valueOf(scanner.nextLine());

        int[][] matrix = new int[matrixDimension][matrixDimension];

        for (int row = 0; row < matrixDimension; row++) {

            int[] numbersForCol = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < matrixDimension; col++) {

                matrix[row][col] = numbersForCol[col];
            }
        }

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        int primaryDiagonalCol = 0;
        int secondaryDiagonalCol = matrixDimension - 1;

        for (int row = 0; row < matrixDimension; row++) {

            primaryDiagonalCol = row;
            primaryDiagonalSum += matrix[row][primaryDiagonalCol];

            secondaryDiagonalSum += matrix[row][secondaryDiagonalCol];
            secondaryDiagonalCol--;
        }

        int diff = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println(diff);

    }
}
