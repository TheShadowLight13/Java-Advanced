import java.util.Scanner;

public class MaxSequenceInMatrix {

    static int maxSequenceCount = 0;
    static String maxSequenceString = "";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDimension = scanner.nextLine().split(" ");
        int rows = Integer.valueOf(matrixDimension[0]);
        int columns = Integer.valueOf(matrixDimension[1]);

        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < rows; row++) {

            String[] input = scanner.nextLine().split(" ");

            for (int col = 0; col < columns; col++) {

                matrix[row][col] = input[col];
            }
        }

        checkRows(matrix);
        checkColumns(matrix);
        checkPrimaryDiagonals(matrix);
        checkSecondaryDiagonals(matrix);

        for (int i = 0; i < maxSequenceCount; i++) {

            System.out.printf("%s, ", maxSequenceString);
        }
    }

    private static void checkRows(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            String stringToCheck = matrix[row][0];
            int sequenceCount = 1;

            for (int col = 1; col < matrix[row].length; col++) {

                String currString = matrix[row][col];

                if (stringToCheck.equals(currString)){

                    sequenceCount++;
                }else {

                    stringToCheck = matrix[row][col];
                    sequenceCount = 1;
                }

                if (sequenceCount >= maxSequenceCount) {

                    maxSequenceCount = sequenceCount;
                    maxSequenceString = stringToCheck;
                }
            }
        }
    }

    // Check columns
    private static void checkColumns(String[][] matrix) {

        for (int col = 0; col < matrix[0].length; col++) {

            String stringToCheck = matrix[0][col];
            int sequenceCount = 1;

            for (int row = 1; row < matrix.length; row++) {

                String currString = matrix[row][col];

                if (stringToCheck.equals(currString)){

                    sequenceCount++;
                }else {

                    stringToCheck = matrix[row][col];
                    sequenceCount = 1;
                }

                if (sequenceCount >= maxSequenceCount) {

                    maxSequenceCount = sequenceCount;
                    maxSequenceString = stringToCheck;
                }
            }
        }
    }

    // Check primaries diagonals
    private static void checkPrimaryDiagonals(String[][] matrix) {

        String stringToCheck = matrix[0][0];
        int sequenceCount = 1;

        for (int row = 1; row < matrix.length; row++) {

            int col = row;

            if (col >= matrix[row].length) {
                return;
            }

            String currString = matrix[row][col];

            if (stringToCheck.equals(currString)){

                sequenceCount++;
            }else {

                stringToCheck = matrix[row][col];
                sequenceCount = 1;
            }

            if (sequenceCount >= maxSequenceCount) {

                maxSequenceCount = sequenceCount;
                maxSequenceString = stringToCheck;
            }
        }
    }

    private static void checkSecondaryDiagonals(String[][] matrix) {

        String stringToCheck = matrix[0][matrix[0].length - 1];
        int sequenceCount = 1;

        int col = matrix[0].length - 2;

        for (int row = 0; row < matrix.length; row++) {

            if (col < 0) {
                return;
            }

            String currString = matrix[row][col];

            if (stringToCheck.equals(currString)){

                sequenceCount++;
            }else {

                stringToCheck = matrix[row][col];
                sequenceCount = 1;
            }

            if (sequenceCount >= maxSequenceCount) {

                maxSequenceCount = sequenceCount;
                maxSequenceString = stringToCheck;
            }

            col--;
        }
    }
}
