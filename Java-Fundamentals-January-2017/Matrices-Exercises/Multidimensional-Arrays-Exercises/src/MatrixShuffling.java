import java.util.Scanner;

public class MatrixShuffling {

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

        String commands = scanner.nextLine();
        while (!commands.equals("END")) {

            String[] commandArgs = commands.split(" ");
            performSwap(matrix, commandArgs);

            commands = scanner.nextLine();
        }
    }

    private static void performSwap(String[][] matrix, String[] commandsArgs) {

        String command = commandsArgs[0];
        boolean isValidCommands = false;

        if (commandsArgs.length != 5 || !command.equals("swap")) {

            System.out.println("Invalid input!");
            return;
        }

        int swapRow1 = Integer.valueOf(commandsArgs[1]);
        int swapCol1 = Integer.valueOf(commandsArgs[2]);
        int swapRow2 = Integer.valueOf(commandsArgs[3]);
        int swapCol2 = Integer.valueOf(commandsArgs[4]);

        if ((swapRow1 >= 0 && swapRow1 < matrix.length) &&
                (swapCol1 >= 0 && swapCol1 < matrix[swapRow1].length)) {

            if ((swapRow2 >= 0 && swapRow2 < matrix.length) &&
                    (swapCol2 >= 0 && swapCol2 < matrix[swapRow2].length)) {

                String valueToSwap = matrix[swapRow1][swapCol1];
                matrix[swapRow1][swapCol1] = matrix[swapRow2][swapCol2];
                matrix[swapRow2][swapCol2] = valueToSwap;
                isValidCommands = true;
            }
        }

        if (!isValidCommands) {

            System.out.println("Invalid input!");
            return;
        }

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                System.out.printf("%s ", matrix[row][col]);
            }

            System.out.println();
        }
    }
}
