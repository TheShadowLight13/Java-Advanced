import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameOfNames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> scoresByPlayerName = new LinkedHashMap<>();
        int playersCount = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < playersCount; i++)
        {
            String playerName = scanner.nextLine();
            int initialPlayerScores = Integer.valueOf(scanner.nextLine());

            int totalPlayerScores = getTotalPlayerScores(playerName, initialPlayerScores);
            scoresByPlayerName.put(playerName, totalPlayerScores);
        }

        scoresByPlayerName = scoresByPlayerName.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));

        Map.Entry<String, Integer> firstEntry = scoresByPlayerName.entrySet().iterator().next();

        String winnerName = firstEntry.getKey();
        int winnerPoints = firstEntry.getValue();

        System.out.printf("The winner is %s - %d points\n", winnerName, winnerPoints);
    }

    private static int getTotalPlayerScores(String playerName, int initialPlayerScores) {

        int totalPlayerScores = initialPlayerScores;

        for (int i = 0; i < playerName.length(); i++)
        {
            int symbolValue = playerName.charAt(i);

            if (symbolValue % 2 == 0)
            {
                totalPlayerScores += symbolValue;
            }
            else
            {
                totalPlayerScores -= symbolValue;
            }
        }

        return totalPlayerScores;
    }
}
