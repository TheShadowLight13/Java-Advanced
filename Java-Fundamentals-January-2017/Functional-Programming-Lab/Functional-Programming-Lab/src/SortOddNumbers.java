import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SortOddNumbers {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            ArrayList<Integer> numbers = new ArrayList<>();
            String[] tokens = reader.readLine().split("[,\\s+]+");

            for (int i = 0; i < tokens.length; i++) {
                numbers.add(Integer.valueOf(tokens[i]));
            }

            numbers.removeIf(n -> n % 2 != 0);
            print(numbers);

            numbers.sort((a,b) -> a.compareTo(b));
            print(numbers);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(ArrayList<Integer> numbers) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i));
            result.append(", ");
        }

        if (numbers.size() != 0) {
            result.delete(result.length() - 2, result.length());
        }

        System.out.println(result);
    }
}
