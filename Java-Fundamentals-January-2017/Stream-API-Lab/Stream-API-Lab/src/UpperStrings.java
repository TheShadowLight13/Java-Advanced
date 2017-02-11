import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class UpperStrings {

    public static void main(String[] args) {

       try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

           ArrayList<String> words = new ArrayList<>();
           words.addAll(Arrays.asList(reader.readLine().split("\\s+")));

           words.stream().map(w -> w.toUpperCase())
                   .forEach(w -> System.out.printf("%s ", w));

       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
