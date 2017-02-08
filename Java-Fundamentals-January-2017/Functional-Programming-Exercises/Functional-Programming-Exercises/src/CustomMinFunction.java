import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String[] tokens = reader.readLine().split("\\s+");
            Integer[] numbersArr = new Integer[tokens.length];

            for (int i = 0; i < tokens.length; i++) {

                String currToken = tokens[i];
                numbersArr[i] = Integer.valueOf(currToken);
            }

            Function<Integer[], Integer> minValue = numbers -> getMinValue(numbers);
            System.out.println(minValue.apply(numbersArr));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getMinValue(Integer[] numbers) {

        int minValue = Integer.MAX_VALUE;

        for (int number : numbers) {

            if (number < minValue) {
                minValue = number;
            }
        }

        return minValue;
    }
}
