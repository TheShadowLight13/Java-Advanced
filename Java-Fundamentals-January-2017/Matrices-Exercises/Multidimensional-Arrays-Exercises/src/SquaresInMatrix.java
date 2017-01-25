import java.util.Scanner;

public class SquaresInMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDimension = scanner.nextLine().split(" ");
        int rows = Integer.valueOf(matrixDimension[0]);
        int columns = Integer.valueOf(matrixDimension[1]);

        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < rows; row++) {

            String[] symbolsForCol = scanner.nextLine().split(" ");

            for (int col = 0; col < columns; col++) {

                matrix[row][col] = symbolsForCol[col];
            }
        }

        int equalsCount = 0;

        for (int row = 0; row < rows - 1; row++) {

            for (int col = 0; col < columns - 1; col++) {

                String firstRowChar1 = matrix[row][col];
                String firstRowChar2 = matrix[row][col + 1];
                String secondRowChar1 = matrix[row + 1][col];
                String secondRowChar2 = matrix[row + 1][col + 1];

                if (firstRowChar1.equals(firstRowChar2) && firstRowChar1.equals(secondRowChar1) &&
                        firstRowChar1.equals(secondRowChar2)) {

                    equalsCount++;
                }
            }
        }

        System.out.println(equalsCount);
    }
}
