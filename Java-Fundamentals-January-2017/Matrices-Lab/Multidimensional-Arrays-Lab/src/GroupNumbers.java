import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GroupNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());


        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {

            int currentNum = numbers[i];

            if (Math.abs(currentNum) % 3 == 0) {

                matrix.get(0).add(currentNum);

            }else if (Math.abs(currentNum) % 3 == 1) {

                matrix.get(1).add(currentNum);
            }else if (Math.abs(currentNum) % 3 == 2){

                matrix.get(2).add(currentNum);
            }
        }

        for (int row = 0; row < matrix.size(); row++) {

            for (int col = 0; col < matrix.get(row).size(); col++) {

                System.out.printf("%d ", matrix.get(row).get(col));
            }

            System.out.println();
        }
    }
}
