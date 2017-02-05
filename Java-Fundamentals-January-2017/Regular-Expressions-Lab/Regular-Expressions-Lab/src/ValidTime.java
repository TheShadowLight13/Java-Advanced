import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidTime {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String regex = "^(\\d{2}):(\\d{2}):(\\d{2}) [AP]M$";
            Pattern pattern = Pattern.compile(regex);
            String line = reader.readLine();

            while (!line.equals("END")) {

                boolean isValid = false;
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {

                    int hours = Integer.valueOf(matcher.group(1));
                    int minutes = Integer.valueOf(matcher.group(2));
                    int seconds = Integer.valueOf(matcher.group(3));
                    isValid = isValidTime(hours, minutes, seconds);

                }else {
                    isValid = false;
                }

                if (isValid) {
                    System.out.println("valid");
                }else {

                    System.out.println("invalid");
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidTime(int hours, int minutes, int seconds) {

        if (!(hours >= 1 && hours <= 12)) {

            return false;
        }

        if (!(minutes >= 0 && minutes <= 59)) {
            return false;
        }

        if (!(seconds >= 0 && seconds <= 59)) {

            return false;
        }

        return true;
    }
}
