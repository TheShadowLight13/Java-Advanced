import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MinEvenNumber {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            List<Double> evenNumbers = new ArrayList<>();

            Stream.of(reader.readLine().split("\\s+"))
                    .filter(x -> !x.isEmpty())
                    .map(x -> Double.parseDouble(x))
                    .filter(x -> x % 2 == 0)
                    .forEach(x -> evenNumbers.add(x));

            Optional<Double> result = evenNumbers.stream()
                    .sorted((a,b) -> a.compareTo(b)).findFirst();

            if (result.isPresent()) {
                System.out.printf("%.2f", result.get());
            }else {
                System.out.println("No match");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
