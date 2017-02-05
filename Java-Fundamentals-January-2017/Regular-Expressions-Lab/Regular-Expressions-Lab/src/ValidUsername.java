import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsername {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String line = reader.readLine();
            String regex = "^[\\w-]{3,16}$";
            Pattern pattern = Pattern.compile(regex);

            while (!line.equals("END")) {

                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {

                    System.out.println("valid");
                }else  {

                    System.out.println("invalid");
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
