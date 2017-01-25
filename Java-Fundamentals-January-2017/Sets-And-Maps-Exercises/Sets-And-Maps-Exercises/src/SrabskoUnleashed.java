import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SrabskoUnleashed {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> singersByVenue = new LinkedHashMap<>();

        String regex = "(\\D+) @(\\D+) (\\d+) (\\d+)";

        String input = sc.nextLine();
        while (!input.equals("End")) {

            boolean isInputValid = Pattern.matches(regex, input);

            if (isInputValid) {

               Pattern pattern = Pattern.compile(regex);
               Matcher matcher = pattern.matcher(input);

               matcher.find();

               String singer = matcher.group(1);
               String venue = matcher.group(2);
               Long ticketsPrice = Long.valueOf(matcher.group(3));
               Long ticketsCount = Long.valueOf(matcher.group(4));

               if (!singersByVenue.containsKey(venue)) {

                   singersByVenue.put(venue, new LinkedHashMap<>());
               }

               if (!singersByVenue.get(venue).containsKey(singer)) {

                   singersByVenue.get(venue).put(singer, 0L);
               }

               long newEarnings = (ticketsPrice * ticketsCount) + singersByVenue.get(venue).get(singer);
               singersByVenue.get(venue).put(singer, newEarnings);
            }

            input = sc.nextLine();
        }

        for (String venue : singersByVenue.keySet()) {

            LinkedHashMap<String, Long> earningsBySinger = singersByVenue.get(venue);
            earningsBySinger = earningsBySinger.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x,y) -> {throw new AssertionError();},
                            LinkedHashMap::new
                    ));

            System.out.println(venue);

            for (String singer : earningsBySinger.keySet()) {

                long earnings = earningsBySinger.get(singer);

                System.out.printf("#  %s -> %d\n", singer, earnings);
            }
        }
    }
}
