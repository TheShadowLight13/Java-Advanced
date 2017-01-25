import java.util.*;

public class PopulationCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> countryInfo = new LinkedHashMap<>();
        LinkedHashMap<String, Long> populationByCountry = new LinkedHashMap<>();

        String input = sc.nextLine();

        while (!input.equals("report")) {

            String[] tokens = input.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            Long population = Long.valueOf(tokens[2]);

            if (!countryInfo.containsKey(country)) {

                countryInfo.put(country, new LinkedHashMap<>());
            }

            countryInfo.get(country).put(city, population);

            if (!populationByCountry.containsKey(country)) {

                populationByCountry.put(country, 0L);
            }

            populationByCountry.put(country, populationByCountry.get(country) + population);

            input = sc.nextLine();
        }

       countryInfo.entrySet().stream()
               .sorted((x1,x2) -> populationByCountry.get(x2.getKey())
                       .compareTo(populationByCountry.get(x1.getKey())))
               .forEach(country -> {
                   System.out.printf("%s (total population: %d)\n", country.getKey(),
                           populationByCountry.get(country.getKey()));

                   country.getValue().entrySet()
                           .stream().sorted((c1,c2) -> c2.getValue().compareTo(c1.getValue()))
                           .forEach(city -> {
                               System.out.printf("=>%s: %d\n", city.getKey(), city.getValue());
                           });
               });
    }
}
