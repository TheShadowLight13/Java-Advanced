import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateParty {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            ArrayList<String> names = new ArrayList<>();
            names.addAll(Arrays.asList(reader.readLine().split("\\s+")));

            String commands = reader.readLine();

            while (!commands.equals("Party!")) {

                String[] commandsArgs = commands.split("\\s+");
                String actionToBePerformed = commandsArgs[0];
                String condition = commandsArgs[1];
                String conditionArg = commandsArgs[2];

                Predicate<String> tester = createTester(condition, conditionArg);

                if (actionToBePerformed.equals("Double")) {

                    for (int i = 0; i < names.size(); i++) {

                        String currName = names.get(i);
                        if (tester.test(currName)) {

                            names.add(i, currName);
                            i++;
                        }
                    }
                }else {
                    names.removeIf(tester);
                }

                commands = reader.readLine();
            }

            if (names.size() == 0) {
                System.out.println("Nobody is going to the party!");
            }else {
                System.out.printf("%s are going to the party!%n", String.join(", ", names));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<String> createTester(String condition, String conditionArg) {

        switch (condition) {

            case "StartsWith":
                return name -> name.startsWith(conditionArg);
            case "EndsWith":
                return name -> name.endsWith(conditionArg);
            case "Length":
                return name -> name.length() == Integer.valueOf(conditionArg);
            default: return null;
        }
    }
}
