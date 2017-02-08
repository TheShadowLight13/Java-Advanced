import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String[] numsStr = reader.readLine().split(", ");
            Function<String, Integer> parser = n -> Integer.valueOf(n);

            int sum = 0;

            for (int i = 0; i < numsStr.length; i++) {

                sum += parser.apply(numsStr[i]);
            }

            System.out.printf("Count = %d%n", numsStr.length);
            System.out.printf("Sum = %d%n", sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
