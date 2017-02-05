import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String regex = "^([A-Z][a-z]+) ([A-Z][a-z]+)$";
            Pattern pattern = Pattern.compile(regex);

            Matcher matcher;

            String line = reader.readLine();

            while (!line.equals("end")) {

                matcher = pattern.matcher(line);
                if (matcher.find()) {

                    System.out.println(matcher.group());
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
