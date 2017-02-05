import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            StringBuilder text = new StringBuilder();

            String line = reader.readLine();
            while (!line.equals("end")) {

                text.append(line);
                line = reader.readLine();
            }

            String emailRegex = "^\\s*?([a-zA-Z0-9]+([.\\-_][a-zA-Z0-9]+)*?)@([a-zA-Z-]+)(\\.[a-zA-Z-]+)+";
            Pattern emailPattern = Pattern.compile(emailRegex);

            String[] emails = text.toString().split("[,\\s+]");

            for (int i = 0; i < emails.length; i++) {

                String currEmail = emails[i].trim();
                Matcher matcher = emailPattern.matcher(currEmail);

                if (matcher.find()) {
                    System.out.println(matcher.group());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
