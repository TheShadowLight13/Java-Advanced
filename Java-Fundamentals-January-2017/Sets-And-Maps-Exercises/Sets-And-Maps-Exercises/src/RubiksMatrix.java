import java.util.Scanner;

public class RubiksMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] matrixSize = sc.nextLine().split(" ");
        int rows = Integer.valueOf(matrixSize[0]);
        int columns = Integer.valueOf(matrixSize[1]);

        int[][] matrix = new int[rows][columns];

        int nextValue = 1;
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < columns; col++) {

                matrix[row][col] = nextValue;
                nextValue++;
            }
        }

        int commandsCount = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < commandsCount; i++) {

            String[] command = sc.nextLine().split(" ");

            int moves = Integer.valueOf(command[2]);
            String direction = command[1];
            if (direction.equals("left") || direction.equals("right")) {

                int rowToSwap = Integer.valueOf(command[0]);
                SwapRow(matrix, direction, rowToSwap, moves);

            }else {

                int columnToSwap = Integer.valueOf(command[0]);
                SwapColumn(matrix, direction, columnToSwap ,moves);
            }
        }

        int correctValue = 1;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < columns; col++) {

                int valueInMatrix = matrix[row][col];

                if (correctValue == valueInMatrix) {

                    System.out.println("No swap required");
                }else {

                    int[] correctValueCoordinates = GetValueCoordinates(matrix, correctValue);
                    int correctValueRow = correctValueCoordinates[0];
                    int correctValueCol = correctValueCoordinates[1];

                    matrix[row][col] = correctValue;
                    matrix[correctValueRow][correctValueCol] = valueInMatrix;
                    System.out.printf("Swap (%d, %d) with (%d, %d)\n",
                            row, col, correctValueRow, correctValueCol);

                }

                correctValue++;
            }
        }
    }

    private static int[] GetValueCoordinates(int[][] matrix, int correctValue) {

        int[] correctValueCoordinates = new int[2];

        for (int row = 0; row < matrix[0].length; row++) {

            for (int col = 0; col < matrix[1].length; col++) {

                if (matrix[row][col] == correctValue) {

                    correctValueCoordinates[0] = row;
                    correctValueCoordinates[1] = col;
                    return correctValueCoordinates;
                }
            }
        }

        return correctValueCoordinates;
    }

    private static void SwapRow(int[][] matrix, String direction, int rowToSwap, int moves) {

        if (direction.equals("left")) {

            for (int i = 0; i < moves % matrix[0].length; i++) {

                int firstElement = matrix[rowToSwap][0];

                for (int col = 0; col < matrix[1].length - 1; col++) {

                    matrix[rowToSwap][col] = matrix[rowToSwap][col + 1];
                }

                matrix[rowToSwap][matrix[1].length - 1] = firstElement;
            }

        }else {

            for (int i = 0; i < moves % matrix[0].length; i++) {

                int lastElement = matrix[rowToSwap][matrix[1].length - 1];

                for (int col = matrix[1].length - 1; col >= 1; col--) {

                    matrix[rowToSwap][col] = matrix[rowToSwap][col - 1];
                }

                matrix[rowToSwap][0] = lastElement;
            }
        }
    }

    private static void SwapColumn(int[][] matrix, String direction, int columnToSwap, int moves) {

        if (direction.equals("up")) {

            for (int i = 0; i < moves % matrix[1].length; i++) {

                int firstElement = matrix[0][columnToSwap];

                for (int row = 0; row < matrix[0].length - 1; row++) {

                    matrix[row][columnToSwap] = matrix[row + 1][columnToSwap];
                }

                matrix[matrix[0].length - 1][columnToSwap] = firstElement;
            }

        }else {

            for (int i = 0; i < moves % matrix[1].length; i++) {

                int lastElement = matrix[matrix[0].length - 1][columnToSwap];

                for (int row = matrix[0].length - 1; row >= 1; row--) {

                    matrix[row][columnToSwap] = matrix[row - 1][columnToSwap];
                }

                matrix[0][columnToSwap] = lastElement;
            }
        }
    }
}
