import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceATag {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String regex = "<a href=(\".+?\")>(\\n)*(.+?)</a>";

            StringBuilder text = new StringBuilder();
            String line = reader.readLine();

            while (!line.equals("END")) {

                text.append(line);
                text.append("\n");
                line = reader.readLine();
            }

            String result = text.toString().replaceAll(regex, "[URL href=$1]$2$3[URL]");
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
