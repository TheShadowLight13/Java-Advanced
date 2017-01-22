import java.util.Arrays;
import java.util.Scanner;

public class ReadSortPrintArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countOfElements = Integer.valueOf(scanner.nextLine());
        String[] lines = new String[countOfElements];

        for (int i = 0; i < countOfElements; i++) {

            lines[i] = scanner.nextLine();
        }

        Arrays.sort(lines);
        System.out.println(String.join("\n", lines));
    }
}
