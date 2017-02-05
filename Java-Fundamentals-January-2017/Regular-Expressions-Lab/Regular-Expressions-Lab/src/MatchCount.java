import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchCount {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String wordToSearch = reader.readLine();
            String text = reader.readLine();

            Pattern pattern = Pattern.compile(wordToSearch);
            Matcher matcher = pattern.matcher(text);

            int occurrencesCount = 0;
            while (matcher.find()) {
                occurrencesCount++;
            }

            System.out.println(occurrencesCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
