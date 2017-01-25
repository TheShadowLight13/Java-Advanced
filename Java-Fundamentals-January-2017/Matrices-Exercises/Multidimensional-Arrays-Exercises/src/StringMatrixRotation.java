import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int degreesStartIndex = command.indexOf("(") + 1;
        int degreesEndIndex = command.length() - 1;
        int rotateDegrees = Integer.valueOf(
                command.substring(degreesStartIndex, degreesEndIndex));

        // Fill the matrix
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();

        int maxColumns = 0;

        String input = scanner.nextLine();
        int currRow = 0;

        while (!input.equals("END")) {

            char[] symbols = input.toCharArray();

            if (symbols.length > maxColumns) {

                maxColumns = symbols.length;
            }

            matrix.add(new ArrayList<>());

            for (int i = 0; i < symbols.length; i++) {

                matrix.get(currRow).add(symbols[i]);
            }

            currRow++;
            input = scanner.nextLine();
        }

        // Pad matrix with empty spaces
        for (int row = 0; row < matrix.size(); row++) {

            for (int col = matrix.get(row).size(); col < maxColumns; col++) {

                matrix.get(row).add(' ');
            }
        }

        int rotateCount = (rotateDegrees / 90) % 4;
        for (int i = 0; i < rotateCount; i++) {

            matrix = rotateMatrix(matrix);
        }

        // Print matrix
        for (int row = 0; row < matrix.size(); row++) {

            for (int col = 0; col < matrix.get(row).size(); col++) {

                System.out.printf("%s", matrix.get(row).get(col));
            }

            System.out.println();
        }
    }

    // Rotate matrix
    private static ArrayList<ArrayList<Character>> rotateMatrix(ArrayList<ArrayList<Character>> matrix) {

        ArrayList<ArrayList<Character>> finalMatrix = new ArrayList<>();

        int columnsCount = matrix.get(0).size();
        for (int col = 0; col < columnsCount; col++) {

            int finalMatrixRow = col;
            finalMatrix.add(new ArrayList<>());

            for (int row = matrix.size() - 1; row >= 0; row--) {

                char matrixValue = matrix.get(row).get(col);
                finalMatrix.get(finalMatrixRow).add(matrixValue);
            }
        }

        return finalMatrix;
    }
}
