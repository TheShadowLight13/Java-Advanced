import java.util.Scanner;

public class TargetPractice {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] matrixSize = sc.nextLine().split(" ");

        int matrixRows = Integer.valueOf(matrixSize[0]);
        int matrixColumns = Integer.valueOf(matrixSize[1]);

        char[][] matrix = new char[matrixRows][matrixColumns];
        String snake = sc.nextLine();

        int currSnakeIndex = 0;
        int startColIndex = 0;
        int dir = -1;

        for (int row = matrixRows - 1; row >= 0; row--) {

            if (dir == -1) {

                startColIndex = matrixColumns - 1;
            }else {

                startColIndex = 0;
            }

            for (int col = startColIndex; dir == -1 ? col >= 0 : col < matrixColumns; col+=dir) {

                if (currSnakeIndex >= snake.length()) {

                    currSnakeIndex = 0;
                }

                matrix[row][col] = snake.charAt(currSnakeIndex);
                currSnakeIndex++;
            }

            dir = -dir;
        }

        String[] shotArgs = sc.nextLine().split(" ");
        int impactRow = Integer.valueOf(shotArgs[0]);
        int impactCol = Integer.valueOf(shotArgs[1]);
        int radius = Integer.valueOf(shotArgs[2]);

        ShootSnake(matrix, matrixRows, matrixColumns, impactRow, impactCol, radius);
        GetResultMatrix(matrix, matrixRows, matrixColumns);

        // Print result matrix
        for (int row = 0; row < matrixRows; row++) {

            for (int col = 0; col < matrixColumns; col++) {

                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static void ShootSnake(
            char[][] matrix, int matrixRows, int matrixColumns, int impactRow, int impactCol, int radius) {

        for (int row = 0; row < matrixRows; row++) {

            for (int col = 0; col < matrixColumns; col++) {

                double distance =
                        Math.sqrt((Math.pow(impactRow - row, 2)) + (Math.pow(impactCol - col, 2)));

                if (distance <= radius) {

                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static void GetResultMatrix(char[][] matrix, int matrixRows, int matrixColumns) {

        for (int col = 0; col < matrixColumns; col++) {

            while (true) {

                boolean isFallen = false;

                for (int row = matrixRows - 1; row >= 1; row--) {

                    char previousChar = matrix[row - 1][col];
                    char currChar = matrix[row][col];

                    if (currChar == ' ' && previousChar != ' ') {

                        matrix[row][col] = previousChar;
                        matrix[row - 1][col] = currChar;
                        isFallen = true;
                    }
                }

                if (!isFallen) {

                    break;
                }
            }
        }
    }
}
