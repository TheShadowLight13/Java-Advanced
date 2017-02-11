import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BoundedNumbers {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int[] bounds = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(n -> Integer.valueOf(n)).toArray();
            int lowerBound = Math.min(bounds[0], bounds[1]);
            int upperBound = Math.max(bounds[0], bounds[1]);

            ArrayList<Integer> numbers = new ArrayList<>();

            String[] tokens = reader.readLine().split(" ");
            for (String token : tokens) {
                numbers.add(Integer.valueOf(token));
            }

            numbers = numbers.stream().filter(n -> n >= lowerBound && n <= upperBound)
                    .collect(Collectors.toCollection(ArrayList::new));

            for (Integer number : numbers) {
                System.out.printf("%d ", number);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
