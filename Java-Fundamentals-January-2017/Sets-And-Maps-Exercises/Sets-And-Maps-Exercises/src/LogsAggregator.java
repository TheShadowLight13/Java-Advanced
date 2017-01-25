import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        TreeMap<String, TreeMap<String, Integer>> ipAddressesByUser = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = sc.nextLine().split(" ");

            String ipAddress = tokens[0];
            String user = tokens[1];
            Integer duration = Integer.valueOf(tokens[2]);

            if (!ipAddressesByUser.containsKey(user)) {

                ipAddressesByUser.put(user, new TreeMap<>());
            }

            if (!ipAddressesByUser.get(user).containsKey(ipAddress)) {

                ipAddressesByUser.get(user).put(ipAddress, 0);
            }

            int newDuration = ipAddressesByUser.get(user).get(ipAddress) + duration;
            ipAddressesByUser.get(user).put(ipAddress, newDuration);
        }

        for (String user : ipAddressesByUser.keySet()) {

            int totalDuration = ipAddressesByUser.get(user).values()
                    .stream().mapToInt(Integer::intValue).sum();

             TreeMap<String, Integer> ipAddresses = ipAddressesByUser.get(user);

            System.out.printf("%s: %d [%s]\n", user, totalDuration,
                    String.join(", ", ipAddresses.keySet()));
        }
    }
}
