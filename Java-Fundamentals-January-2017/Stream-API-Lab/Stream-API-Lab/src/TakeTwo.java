
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TakeTwo {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String[] tokens = reader.readLine().split("\\s+");
            ArrayList<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < tokens.length; i++) {

                numbers.add(Integer.valueOf(tokens[i]));
            }

            numbers.stream().distinct().filter(n -> n >= 10 && n <= 20)
                    .limit(2)
                    .forEach(n -> System.out.printf("%d ", n));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
