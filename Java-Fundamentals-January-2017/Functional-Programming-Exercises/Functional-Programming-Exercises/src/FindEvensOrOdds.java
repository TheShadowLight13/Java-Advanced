import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String[] tokens = reader.readLine().split(" ");
            int lowerBound = Integer.valueOf(tokens[0]);
            int upperBound = Integer.valueOf(tokens[1]);

            String numbersType = reader.readLine();
            Predicate<Integer> tester = createTester(numbersType);

            for (int num = lowerBound; num <= upperBound; num++) {

                if (tester.test(num)) {

                    System.out.printf("%d ", num);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Integer> createTester(String numbersType) {

        switch (numbersType) {
            case "even":
               return number -> (number % 2 == 0);
            case "odd":
                return number -> (number % 2 != 0);
            default:
                return null;
        }
    }
}
