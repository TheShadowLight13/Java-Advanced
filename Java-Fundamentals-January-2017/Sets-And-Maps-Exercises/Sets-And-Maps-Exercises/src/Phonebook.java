import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        boolean isToSearch = false;

        HashMap<String, String> phoneBook = new HashMap<>();

        while (!input.equals("stop")) {

            if (isToSearch) {

                String name = input;

                if (phoneBook.containsKey(name)) {

                    String phoneNumber = phoneBook.get(name);
                    System.out.printf("%s -> %s\n", name, phoneNumber);
                }else {

                    System.out.printf("Contact %s does not exist.\n", name);
                }
            }

            if (!input.equals("search") && !isToSearch) {

                String[] tokens = input.split("-");
                String name = tokens[0];
                String phoneNumber = tokens[1];

                phoneBook.put(name, phoneNumber);
            }else {

                isToSearch = true;
            }

            input = sc.nextLine();
        }
    }
}
