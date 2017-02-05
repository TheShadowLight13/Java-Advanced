import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String keysString = reader.readLine();
            String textString = reader.readLine();

            String startKeyRegex = "^([a-zA-Z_]+)[0-9]";
            String endKeyRegex = "[0-9]([a-zA-Z_]+)$";

            Pattern startKeyPattern = Pattern.compile(startKeyRegex);
            Pattern endKeyPattern = Pattern.compile(endKeyRegex);

            Matcher matcher;
            matcher = startKeyPattern.matcher(keysString);

            if (!matcher.find()) {
                System.out.println("<p>A key is missing</p>");
                return;
            }

            String startKey = matcher.group(1);
            matcher = endKeyPattern.matcher(keysString);

            if (!matcher.find()) {
                System.out.println("<p>A key is missing</p>");
                return;
            }

            String endKey = matcher.group(1);
            String numbersRegex = startKey + "(.*?)" + endKey;
            Pattern numbersPattern = Pattern.compile(numbersRegex);

            matcher = numbersPattern.matcher(textString);

            double totalSum = 0;
            while (matcher.find()) {

                String currMatch = matcher.group(1);
                if (tryParse(currMatch)) {
                    double currNum = Double.valueOf(currMatch);
                    totalSum = totalSum + currNum;
                }
            }

            if (totalSum == 0) {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }else {

                System.out.printf("<p>The total value is: <em>%.2f</em></p>", totalSum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean tryParse(String string) {
        try {
            Double.parseDouble(string);
        }catch (Exception e) {
            return false;
        }

        return true;
    }
}
