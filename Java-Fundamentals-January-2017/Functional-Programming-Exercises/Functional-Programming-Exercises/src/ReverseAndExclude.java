import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class ReverseAndExclude {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            ArrayList<Integer> numbers = new ArrayList<>();
            String[] tokens = reader.readLine().split("\\s+");

            for (String token : tokens) {

                numbers.add(Integer.valueOf(token));
            }

            Collections.reverse(numbers);
            Integer n = Integer.valueOf(reader.readLine());
            Predicate<Integer> isDivided = number -> number % n == 0;

            for (int i = 0; i < numbers.size(); i++) {

                Integer currNum = numbers.get(i);
                if (!isDivided.test(currNum)) {
                    System.out.printf("%d ", currNum);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
