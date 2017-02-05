import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String text = reader.readLine().toLowerCase();

            String regex = "[aeiouy]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            int vowelsCount = 0;
            while (matcher.find()) {
                vowelsCount++;
            }

            System.out.printf("Vowels: %d%n", vowelsCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
