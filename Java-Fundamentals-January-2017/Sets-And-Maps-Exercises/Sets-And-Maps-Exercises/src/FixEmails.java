import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        LinkedHashMap<String, String> emailByName = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            String name = input;
            String email = sc.nextLine().toLowerCase();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {

                emailByName.put(name, email);
            }

            input = sc.nextLine();
        }

        for (Map.Entry<String, String> entry : emailByName.entrySet()) {

            String name = entry.getKey();
            String email = entry.getValue();

            System.out.printf("%s -> %s\n", name, email);
        }

    }
}
