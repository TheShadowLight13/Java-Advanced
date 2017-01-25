import java.util.Scanner;

public class FillMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int matrixDimension = Integer.valueOf(input[0]);
        String matrixType = input[1];
        
        int[][] matrix = new int[matrixDimension][matrixDimension];

        int dir = 1;
        int startRow = 0;
        int currValue = 1;

        for (int col = 0; col < matrixDimension; col++) {

            for (int row = startRow; startRow == 0 ? row < matrixDimension : row >= 0; row+=dir) {

                matrix[row][col] = currValue;
                currValue++;
            }

            if (matrixType.equals("B")) {

                dir = -dir;
                startRow = startRow == 0 ? matrixDimension - 1 : 0;
            }
        }

        for (int row = 0; row < matrixDimension; row++) {

            for (int col = 0; col < matrixDimension; col++) {

                System.out.printf("%d ", matrix[row][col]);
            }

            System.out.println();
        }

    }
}
