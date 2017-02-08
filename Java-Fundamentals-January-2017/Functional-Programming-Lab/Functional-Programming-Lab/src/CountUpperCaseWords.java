import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CountUpperCaseWords {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String text = reader.readLine();
            ArrayList<String> words = new ArrayList<>();
            words.addAll(Arrays.asList(text.split("\\s+")));

            words.removeIf(w -> Character.isLowerCase(w.charAt(0)));
            System.out.println(words.size());
            System.out.println(String.join("\n", words));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
