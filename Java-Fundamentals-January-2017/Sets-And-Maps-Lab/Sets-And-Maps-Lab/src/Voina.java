import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        LinkedHashSet<Integer> firstPlayerDeck = new LinkedHashSet<>();
        fillSet(firstPlayerDeck, firstPlayerCards);

        LinkedHashSet<Integer> secondPlayerDeck = new LinkedHashSet<>();
        fillSet(secondPlayerDeck, secondPlayerCards);

        int round = 50;
        for (int i = 0; i < round; i++) {

            if (firstPlayerDeck.isEmpty() && secondPlayerDeck.isEmpty()) {

                System.out.println("Draw!");
                return;
            }else if (firstPlayerDeck.isEmpty()) {

                System.out.println("Second player win!");
                return;
            }else if (secondPlayerDeck.isEmpty()) {

                System.out.println("First player win!");
                return;
            }

            int firstPlayerCard = firstPlayerDeck.iterator().next();
            int secondPlayerCard = secondPlayerDeck.iterator().next();

            firstPlayerDeck.remove(firstPlayerCard);
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {

                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            }else if (secondPlayerCard > firstPlayerCard){

                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }else {

                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
        }

        if (firstPlayerDeck.size() == secondPlayerDeck.size()) {

            System.out.println("Draw!");
        }else if (firstPlayerDeck.size() > secondPlayerDeck.size()) {

            System.out.println("First player win!");
        }else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {

            System.out.println("Second player win!");
        }
    }

    private static void fillSet(LinkedHashSet<Integer> deck, int[] cards) {

        for (int i = 0; i < cards.length; i++) {

            deck.add(cards[i]);
        }
    }
}
