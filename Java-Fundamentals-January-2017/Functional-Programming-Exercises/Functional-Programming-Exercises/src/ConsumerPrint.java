import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            ArrayList<String> names = new ArrayList<>();
            names.addAll(Arrays.asList(reader.readLine().split("\\s+")));

            Consumer<String> print = name -> System.out.println(name);
            for (String name : names) {
                print.accept(name);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
