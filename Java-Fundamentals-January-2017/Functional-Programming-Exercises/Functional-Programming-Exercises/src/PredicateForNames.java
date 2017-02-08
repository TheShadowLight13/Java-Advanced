import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            Integer targetLen = Integer.valueOf(reader.readLine());
            String[] names = reader.readLine().split("\\s+");

            Predicate<String> isLessOrEqualLen = name -> name.length() <= targetLen;

            for (String name : names) {
                if (isLessOrEqualLen.test(name)) {
                    System.out.println(name);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
