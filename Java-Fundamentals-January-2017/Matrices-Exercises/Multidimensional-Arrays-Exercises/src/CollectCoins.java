import java.util.Scanner;

public class CollectCoins {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = 4;

        char[][] matrix = new char[rows][];

        for (int row = 0; row < rows; row++) {

            String input = scanner.nextLine();
            matrix[row] = new char[input.length()];

            for (int col = 0; col < matrix[row].length; col++) {

                matrix[row][col] = input.charAt(col);
            }
        }

        String commands = scanner.nextLine();

        int startRow = 0;
        int startCol = 0;

        int previousValidRow = startRow;
        int previousValidCol = startCol;

        int coinsCollected = 0;
        int wallsHitted = 0;

        for (int i = 0; i < commands.length(); i++) {

            char currentCommand = commands.charAt(i);

            if (currentCommand == 'V') {

                startRow = startRow + 1;
            }else if (currentCommand == '>') {

                startCol = startCol + 1;
            }else if (currentCommand == '^') {

                startRow = startRow - 1;
            }else if (currentCommand == '<'){

                startCol = startCol - 1;
            }

            if ((startRow >= 0 && startRow < matrix.length) &&
                    (startCol >= 0 && startCol < matrix[startRow].length)) {

                if (matrix[startRow][startCol] == '$') {

                    coinsCollected++;
                }
            }else {

                if (currentCommand == 'V') {

                    startRow = startRow - 1;
                }else if (currentCommand == '>') {

                    startCol = startCol - 1;
                }else if (currentCommand == '^') {

                    startRow = startRow + 1;
                }else if (currentCommand == '<'){

                    startCol = startCol + 1;
                }

                wallsHitted++;
            }
        }

        System.out.printf("Coins = %d%n", coinsCollected);
        System.out.printf("Walls = %d", wallsHitted);
    }
}
