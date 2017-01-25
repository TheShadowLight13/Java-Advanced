import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimension = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = matrixDimension[0];
        int columns = matrixDimension[1];

        char firstLastLetter = 'a';
        char middleLetter = 'a';

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < columns; col++) {

                String palindrome =
                        String.valueOf(firstLastLetter) + String.valueOf(middleLetter) + String.valueOf(firstLastLetter);
                System.out.printf("%s ", palindrome);
                middleLetter++;
            }

            System.out.println();
            firstLastLetter++;
            middleLetter = firstLastLetter;
        }
    }
}
