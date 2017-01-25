import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LegoBlocks {

    public static int totalMatrixCells = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int matrixRows = Integer.valueOf(scanner.nextLine().trim());

        int[][] firstMatrix = new int[matrixRows][];
        int[][] secondMatrix = new int[matrixRows][];

        // Initialize firstMatrix
        initializeMatrix(firstMatrix, scanner);

        // Initialize secondMatrix
        initializeMatrix(secondMatrix, scanner);

        reverseMatrix(secondMatrix);
        int[][] newMatrix = mergeMatrix(firstMatrix, secondMatrix, matrixRows);
        boolean isMatchedMatrix = isMatrixMatched(newMatrix);

        if (isMatchedMatrix) {

          PrintMatrix(newMatrix);

        }else {

            System.out.printf("The total number of cells is: %d", totalMatrixCells);
        }
    }

    private static void PrintMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            System.out.print("[");

            for (int col = 0; col < matrix[row].length - 1; col++) {

                System.out.printf("%d, ", matrix[row][col]);
            }

            System.out.print(matrix[row][matrix[row].length - 1]);
            System.out.println("]");
        }
    }

    private static void reverseMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length / 2; col++) {

                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix[row].length - col - 1];
                matrix[row][matrix[row].length - col - 1] = temp;
            }
        }
    }

    private static int[][] mergeMatrix(int[][] firstMatrix, int[][] secondMatrix, int matrixRows) {

        int[][] newMatrix = new int[matrixRows][];

        for (int row = 0; row < matrixRows; row++) {

            int columnLength = firstMatrix[row].length + secondMatrix[row].length;
            newMatrix[row] = new int[columnLength];

            List<Integer> numbersForCol = new ArrayList<>();
            numbersForCol.addAll(
                    Arrays.stream(firstMatrix[row]).boxed().collect(Collectors.toList()));
            numbersForCol.addAll(
                    Arrays.stream(secondMatrix[row]).boxed().collect(Collectors.toList()));

            for (int col = 0; col < columnLength; col++) {

                newMatrix[row][col] = numbersForCol.get(col);
            }
        }

        return newMatrix;
    }

    private static boolean isMatrixMatched(int[][] matrix) {

        boolean isMatched = true;
        int firstRowLength = matrix[0].length;

        for (int row = 1; row < matrix.length; row++) {

            if (firstRowLength != matrix[row].length) {

                isMatched = false;
                break;
            }
        }

        return isMatched;
    }

    // Initialize matrix
    private static void initializeMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {

            int[] numbers = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int columnsCount = numbers.length;

            matrix[row] = new int[columnsCount];

            for (int col = 0; col < columnsCount; col++) {

                matrix[row][col] = numbers[col];
                totalMatrixCells++;
            }
        }
    }
}
