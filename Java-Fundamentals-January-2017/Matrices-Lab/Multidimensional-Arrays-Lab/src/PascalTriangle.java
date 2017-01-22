import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.valueOf(scanner.nextLine());

        long[][] pascalTriangle = new long[rows][];
        int currWidth = 1;

        for (int row = 0; row < rows; row++) {

            pascalTriangle[row] = new long[currWidth];
            pascalTriangle[row][0] = 1;

            if (currWidth > 1) {

                pascalTriangle[row][currWidth - 1] = 1;

                for (int col = 0; col < currWidth; col++) {

                    if (pascalTriangle[row][col] == 0) {

                        long sum = pascalTriangle[row - 1][col - 1] +
                                pascalTriangle[row - 1][col];
                        pascalTriangle[row][col] = sum;
                    }
                }

                for (int col = 0; col < currWidth; col++) {

                    System.out.printf("%d ", pascalTriangle[row][col]);
                }
            }else {

                System.out.printf("%d ", pascalTriangle[row][0]);
            }

            currWidth++;
            System.out.println();
        }
    }
}
