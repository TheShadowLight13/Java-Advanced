import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class FindAndSumIntegers {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            Optional<Integer> sum = Arrays.stream(reader.readLine().split("\\s+"))
                    .filter(x -> isNumber(x))
                    .map(x -> Integer.parseInt(x))
                    .reduce((x,y) -> x + y);

            if (sum.isPresent()) {
                System.out.println(sum.get());
            }else {
                System.out.println("No match");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isNumber(String x) {

        try {
            Integer.parseInt(x);
        }catch (Exception e) {
            return false;
        }

        return true;
    }
}
