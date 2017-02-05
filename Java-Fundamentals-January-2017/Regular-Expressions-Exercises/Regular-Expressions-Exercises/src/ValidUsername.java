import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsername {

    public static void main(String[] args) {

       try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

           String text = reader.readLine();
           String[] usernames = text.trim().split("[^a-zA-Z0-9_]");

           ArrayList<String> validUsernames = new ArrayList<>();
           String regex = "^([a-zA-Z][a-zA-Z0-9_]{2,24})$";
           Pattern pattern = Pattern.compile(regex);
           Matcher matcher;

           for (int i = 0; i < usernames.length; i++) {
               String currUsername = usernames[i].trim();
               matcher = pattern.matcher(currUsername);

               if (matcher.find()) {
                   validUsernames.add(currUsername);
               }
           }

           int maxSumOfLen = Integer.MIN_VALUE;
           String firstResultUsername = "";
           String secondResultUsername = "";

           for (int i = 0; i < validUsernames.size() - 1; i++) {

               String firstUsername = validUsernames.get(i);
               String secondUsername = validUsernames.get(i + 1);
               int currSumOfLen = firstUsername.length() + secondUsername.length();

               if (currSumOfLen > maxSumOfLen) {
                   maxSumOfLen = currSumOfLen;
                   firstResultUsername = firstUsername;
                   secondResultUsername = secondUsername;
               }
           }

           System.out.println(firstResultUsername);
           System.out.println(secondResultUsername);

       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
