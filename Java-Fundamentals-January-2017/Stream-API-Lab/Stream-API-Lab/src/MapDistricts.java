import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MapDistricts {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String[] tokens = reader.readLine().split(" ");
            Integer limit = Integer.valueOf(reader.readLine());

            HashMap<String, ArrayList<Integer>> populationByCity = new HashMap<>();

            for (int i = 0; i < tokens.length; i++) {

                String[] cityInfo = tokens[i].split(":");
                String city = cityInfo[0];
                Integer population = Integer.valueOf(cityInfo[1]);

                populationByCity.putIfAbsent(city, new ArrayList<>());
                populationByCity.get(city).add(population);
            }

            Predicate<Map.Entry<String, ArrayList<Integer>>> largerThanLimit = createLargerThanLimit(limit);
            Comparator<Map.Entry<String, ArrayList<Integer>>> descendingPopulationComparator = createDescendingPopulationComparator();
            populationByCity.entrySet().stream()
                    .filter(largerThanLimit)
                    .sorted(descendingPopulationComparator)
                    .forEach(e -> {

                        System.out.printf("%s: ", e.getKey());
                        e.getValue().stream().sorted((p1,p2) -> p2.compareTo(p1))
                                .limit(5)
                                .forEach(p -> System.out.printf("%d ", p));
                        System.out.println();

                    });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Comparator<Map.Entry<String,ArrayList<Integer>>> createDescendingPopulationComparator() {

        return new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<Integer>> firstCity,
                               Map.Entry<String, ArrayList<Integer>> secondCity) {
                return Integer.compare(secondCity.getValue().stream().mapToInt(x -> Integer.valueOf(x)).sum(),
                        firstCity.getValue().stream().mapToInt(x -> Integer.valueOf(x)).sum());
            }
        };
    }


    private static Predicate<Map.Entry<String,ArrayList<Integer>>> createLargerThanLimit(Integer limit) {

        return e -> e.getValue().stream().mapToInt(x -> Integer.valueOf(x)).sum() >= limit;
    }
}
