import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Character> powers =
                Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A');
        List<Character> suits = Arrays.asList('C', 'D', 'H', 'S');

        LinkedHashMap<String, HashSet<String>> cardsByName = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("JOKER")) {

            String[] tokens = input.split(":");

            String name = tokens[0];
            List<String> cards = Arrays.stream(tokens[1].trim().split(", "))
                    .distinct()
                    .collect(Collectors.toList());

            if (!cardsByName.containsKey(name)) {

                cardsByName.put(name, new HashSet<>());
            }

            for (String card : cards) {

                cardsByName.get(name).add(card);
            }

            input = sc.nextLine();
        }

        for (String name : cardsByName.keySet()) {

            HashSet<String> cards = cardsByName.get(name);
            int totalCardsSum = 0;

            for (String card : cards) {

                int cardPowerRate = powers.indexOf(card.charAt(0)) + 2;
                int cardTypeRate = suits.indexOf(card.charAt(card.length() - 1)) + 1;

                totalCardsSum += cardPowerRate * cardTypeRate;
            }

            System.out.printf("%s: %d\n", name, totalCardsSum);
        }
    }
}
