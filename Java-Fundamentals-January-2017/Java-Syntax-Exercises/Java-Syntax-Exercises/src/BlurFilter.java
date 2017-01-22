import java.util.Arrays;
import java.util.Scanner;

public class BlurFilter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long blurAmount = Long.valueOf(scanner.nextLine());
        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int matrixRows = matrixDimensions[0];
        int matrixCols = matrixDimensions[1];
        long[][] pixelsMatrix = new long[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++)
        {
            long[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            for (int col = 0; col < matrixCols; col++)
            {
                pixelsMatrix[row][col] = numbers[col];
            }
        }

        int[] blurCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ApplyBlurFilter(pixelsMatrix, blurAmount, blurCoordinates);
        PrintResult(pixelsMatrix);

    }

    private static void ApplyBlurFilter(long[][] pixelsMatrix, long blurAmount, int[] blurCoordinates)
    {
        int matrixRows = pixelsMatrix.length;
        int matrixCols = 0;

        int blurRow = blurCoordinates[0];
        int blurCol = blurCoordinates[1];

        int startRow = blurRow - 1;
        int endRow = blurRow + 1;
        int startCol = blurCol - 1;
        int endCol = blurCol + 1;

        for (int row = startRow; row <= endRow; row++)
        {
            for (int col = startCol; col <= endCol; col++)
            {
                if ((row >= 0 && row < matrixRows) && (col >= 0 && col < pixelsMatrix[row].length))
                {
                    pixelsMatrix[row][col] += blurAmount;
                }
            }
        }
    }

    private static void PrintResult(long[][] pixelsMatrix)
    {
        int matrixRows = pixelsMatrix.length;
        int matrixCols = 0;

        for (int row = 0; row < matrixRows; row++)
        {
            for (int col = 0; col < pixelsMatrix[row].length; col++)
            {
                System.out.print(pixelsMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
