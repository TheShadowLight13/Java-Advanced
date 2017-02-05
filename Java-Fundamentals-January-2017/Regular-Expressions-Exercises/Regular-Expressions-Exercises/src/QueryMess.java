import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class QueryMess {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String line = reader.readLine();

            while (!line.equals("END")) {

                line = line.trim().replaceAll("[+\\s]+", " ");
                line = line.replaceAll("%20", " ");
                line = line.replaceAll("\\s+", " ");

                if (line.contains("?")) {

                    line = line.substring(line.indexOf("?") + 1);
                }

                String[] tokens = line.split("&");
                LinkedHashMap<String, ArrayList<String>> valueByKey = new LinkedHashMap<>();

                for (int i = 0; i < tokens.length; i++) {

                    String currToken = tokens[i];
                    String[] currTokenData = currToken.split("=");

                    String key = currTokenData[0].trim();
                    String value = currTokenData[1].trim();

                    if (!valueByKey.containsKey(key)) {
                        valueByKey.put(key, new ArrayList<>());
                    }

                    valueByKey.get(key).add(value);
                }

                for (String key : valueByKey.keySet()) {

                    System.out.printf("%s=[%s]", key, String.join(", ", valueByKey.get(key)));
                }

                if (valueByKey.size() != 0) {
                    System.out.println();
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
