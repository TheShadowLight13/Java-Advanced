import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Predicate;

public class ListOfPredicates {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int range = Integer.valueOf(reader.readLine());
            String[] tokens = reader.readLine().split("\\s+");
            HashSet<Integer> divisibleNumbers = new HashSet<>();

            for (int i = 0; i < tokens.length; i++) {

                divisibleNumbers.add(Integer.valueOf(tokens[i]));
            }

            for (int i = 1; i <= range; i++) {

                int currNumber = i;
                boolean isToPrint = true;

                for (Integer divisibleNumber : divisibleNumbers) {

                    Predicate<Integer> tester = createTester(divisibleNumber);
                    if (!tester.test(currNumber)) {
                        isToPrint = false;
                        break;
                    }
                }

                if (isToPrint) {
                    System.out.printf("%d ", currNumber);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Integer> createTester(Integer divisibleNumber) {

        return number -> number % divisibleNumber == 0;
    }
}
