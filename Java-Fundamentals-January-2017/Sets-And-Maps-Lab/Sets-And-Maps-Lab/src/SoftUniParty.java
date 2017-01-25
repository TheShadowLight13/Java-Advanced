import java.util.*;

public class SoftUniParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> numbers = new ArrayList<>(
                Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));

        HashSet<String> regular = new HashSet<>();
        TreeSet<String> vip = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {

            if (numbers.contains(input.charAt(0))) {

                vip.add(input);
            }else {

                regular.add(input);
            }

            input = scanner.nextLine();
        }

        vip.addAll(regular);
        input = scanner.nextLine();

        while (!input.equals("END")) {

            if (vip.contains(input)) {

                vip.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(vip.size());

        for (String guest : vip) {

            System.out.println(guest);
        }
    }
}
