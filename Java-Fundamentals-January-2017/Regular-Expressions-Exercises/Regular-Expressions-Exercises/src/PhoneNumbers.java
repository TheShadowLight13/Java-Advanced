import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            StringBuilder text = new StringBuilder();

            String line = reader.readLine();
            while (!line.equals("END")) {

                text.append(line);
                line = reader.readLine();
            }

            String regex = "([A-Z][a-zA-Z]*)(?:[^a-zA-Z+]*?)([+]?[0-9][0-9()/. -]*[0-9])";
            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(text);

            LinkedHashMap<String, String> phoneNumberByName = new LinkedHashMap<>();

            while (matcher.find()) {

                String name = matcher.group(1);
                String phoneNumber = matcher.group(2).replaceAll("[^0-9+]", "");

                phoneNumberByName.put(name, phoneNumber);
            }

            if (phoneNumberByName.isEmpty()) {
                System.out.println("<p>No matches!</p>");
                return;
            }

            StringBuilder result = new StringBuilder();
            result.append("<ol>");

            for (String name : phoneNumberByName.keySet()) {

                result.append(String.format("<li><b>%s:</b> %s</li>", name, phoneNumberByName.get(name)));
            }

            result.append("</ol>");
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
