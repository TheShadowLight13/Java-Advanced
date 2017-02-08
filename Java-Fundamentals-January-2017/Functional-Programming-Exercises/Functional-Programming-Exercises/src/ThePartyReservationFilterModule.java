import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;

public class ThePartyReservationFilterModule {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            ArrayList<String> names = new ArrayList<>();
            names.addAll(Arrays.asList(reader.readLine().split(" ")));

            HashMap<String, Predicate<String>> filterByFilterType = new HashMap<>();

            String input = reader.readLine();

            while (!input.equals("Print")) {

                String[] commands = input.trim().split(";");
                String commandType = commands[0];
                String filterType = commands[1];
                String filterParam = commands[2];

                Predicate<String> tester = createTester(filterType, filterParam);
                String filterTypeParam = filterType + " " + filterParam;

                if (commandType.equals("Add filter")) {

                    filterByFilterType.put(filterTypeParam, tester);
                }else {

                    filterByFilterType.remove(filterTypeParam);
                }

                input = reader.readLine();
            }

            for (Predicate<String> tester : filterByFilterType.values()) {

                names.removeIf(tester);
            }

            System.out.print(String.join(" ", names));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<String> createTester(String filterType, String filterParam) {

        switch (filterType) {
            case "Starts with":
                return name -> name.startsWith(filterParam);
            case "Ends with":
                return name -> name.endsWith(filterParam);
            case "Length":
                return name -> name.length() == Integer.valueOf(filterParam);
            case "Contains":
                return name -> name.contains(filterParam);
            default: return null;
        }
    }
}
