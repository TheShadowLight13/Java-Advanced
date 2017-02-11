import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FirstName {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            List<String> names = Arrays.asList(reader.readLine().split("\\s+"));
            HashSet<Character> letters = new HashSet<>();

            Stream.of(reader.readLine().split("\\s+"))
                    .map(w -> w.toLowerCase().charAt(0))
                    .forEach(l -> letters.add(l));
            Optional<String> result = names.stream()
                    .filter(n -> letters.contains(n.toLowerCase().charAt(0)))
                    .sorted().findFirst();

            if (result.isPresent()) {
                System.out.println(result.get());
            }else {

                System.out.println("No match");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
