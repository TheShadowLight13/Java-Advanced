import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NonDigitCount {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String text = reader.readLine();

            String regex = "\\D";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            int nonDigitsCount = 0;

            while (matcher.find()) {
                nonDigitsCount++;
            }

            System.out.printf("Non-digits: %d%n", nonDigitsCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
