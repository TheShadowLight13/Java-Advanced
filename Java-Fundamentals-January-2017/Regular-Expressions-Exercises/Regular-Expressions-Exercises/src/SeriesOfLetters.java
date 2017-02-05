import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesOfLetters {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String text = reader.readLine();
            String regex = "(.)\\1+";

            text = text.replaceAll(regex, "$1");
            System.out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
