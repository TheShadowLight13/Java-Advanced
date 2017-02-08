import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int n = Integer.valueOf(reader.readLine());

            LinkedHashMap<String, Integer> ageByName = new LinkedHashMap<>();

            for (int i = 0; i < n; i++) {
                String[] tokens = reader.readLine().split(", ");
                String name = tokens[0];
                Integer age = Integer.valueOf(tokens[1]);

                ageByName.put(name, age);
            }

            String condition = reader.readLine();
            Integer limitAge = Integer.valueOf(reader.readLine());
            String format = reader.readLine();

            Predicate<Integer> tester = createTester(condition, limitAge);
            ageByName.values().removeIf(tester);

            Consumer<LinkedHashMap<String, Integer>> printer = createPrinter(format);
            printer.accept(ageByName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Consumer<LinkedHashMap<String, Integer>> createPrinter(String format) {

        switch (format) {
            case "name":
                return ageByName -> ageByName.keySet().forEach(name -> System.out.println(name));
            case "age":
                return ageByName -> ageByName.values().forEach(age -> System.out.println(age));
            case "name age":
                return ageByName -> ageByName.entrySet().forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));
            default: return null;
        }
    }

    private static Predicate<Integer> createTester(String condition, Integer limitAge) {

        switch (condition) {
            case "younger":
                return age -> age >= limitAge;
            case "older":
                return age -> age <= limitAge;
            default: return null;
        }
    }
}
