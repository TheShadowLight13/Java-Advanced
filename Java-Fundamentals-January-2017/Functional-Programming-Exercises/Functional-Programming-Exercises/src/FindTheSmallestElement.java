import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindTheSmallestElement {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int smallestNum = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < numbers.length; i++) {

                int currNum = numbers[i];

                if (currNum <= smallestNum) {
                    smallestNum = currNum;
                    index = i;
                }
            }

            System.out.println(index);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
