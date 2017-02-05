import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String keyWord = reader.readLine();
            String text = reader.readLine();

            String keyWordRegex = ("\\b" + keyWord + "\\b");
            String sentenceRegex = "([A-Z][^.!?]*[.!?])";
            Pattern keyWordPattern = Pattern.compile(keyWordRegex);
            Pattern sentencePattern = Pattern.compile(sentenceRegex);
            Matcher sentenceMatcher = sentencePattern.matcher(text);

            while (sentenceMatcher.find()) {

                String currSentence = sentenceMatcher.group();
                Matcher keyWordMatcher = keyWordPattern.matcher(currSentence);

                if (keyWordMatcher.find()) {
                    System.out.println(currSentence);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
