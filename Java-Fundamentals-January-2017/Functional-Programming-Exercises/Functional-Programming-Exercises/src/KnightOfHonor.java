import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class KnightOfHonor {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String[] names = reader.readLine().split("\\s+");
            Supplier<String> getHonor = () -> "Sir ";

            for (String name : names) {
                String result = getHonor.get() + name;
                System.out.println(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
