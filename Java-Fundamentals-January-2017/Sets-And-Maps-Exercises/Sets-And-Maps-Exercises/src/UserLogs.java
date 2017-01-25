import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> ipAddressesByName = new TreeMap<>();

        String input = sc.nextLine();
        while (!input.equals("end")) {

            String[] tokens = input.split(" ");
            String ipAddress = tokens[0].replace("IP=", "");
            String username = tokens[2].replace("user=", "");

            if (!ipAddressesByName.containsKey(username)) {

                ipAddressesByName.put(username, new LinkedHashMap<>());
            }

            if (!ipAddressesByName.get(username).containsKey(ipAddress)) {

                ipAddressesByName.get(username).put(ipAddress, 0);
            }

            int newMessagesCount = ipAddressesByName.get(username).get(ipAddress) + 1;
            ipAddressesByName.get(username).put(ipAddress, newMessagesCount);

            input = sc.nextLine();
        }

        for (String username : ipAddressesByName.keySet()) {

            LinkedHashMap<String, Integer> messagesCountByIpAddress = ipAddressesByName.get(username);
            int keysCount = messagesCountByIpAddress.size();

            System.out.printf("%s: \n", username);

            for (String ipAddress : messagesCountByIpAddress.keySet()) {

                keysCount--;

                int messagesCount = messagesCountByIpAddress.get(ipAddress);

                if (keysCount <= 0) {

                    System.out.printf("%s => %d.", ipAddress, messagesCount);
                }else {
                    System.out.printf("%s => %d, ", ipAddress, messagesCount);
                }
            }

            System.out.println();
        }
    }
}
