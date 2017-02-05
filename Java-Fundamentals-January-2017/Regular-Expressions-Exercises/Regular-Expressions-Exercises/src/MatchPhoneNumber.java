import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String regex = "^\\+359(-| )2\\1(\\d{3})\\1(\\d{4})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher;

            String line = reader.readLine();

            while (!line.equals("end")) {

                matcher = pattern.matcher(line);
                if (matcher.find()) {

                    System.out.println(line);
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
