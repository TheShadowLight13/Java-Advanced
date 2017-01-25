import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TerroristsWin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] symbols = scanner.nextLine().toCharArray();

        ArrayList<Character> battlefield = new ArrayList<>();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        for (int i = 0; i < symbols.length; i++) {

            battlefield.add(symbols[i]);
        }

        for (int i = 0; i < symbols.length; i++) {

            char currSymbol = symbols[i];

            if (!indexes.isEmpty() && currSymbol == '|') {

                int startBombIndex = indexes.pop();
                int endBombIndex = i;
                int bombPower = calculateBombPower(battlefield, startBombIndex, endBombIndex);
                detonateBomb(battlefield, startBombIndex, endBombIndex, bombPower);
                continue;
            }

            if (currSymbol == '|') {

                indexes.push(i);
            }
        }

        battlefield.forEach(s -> System.out.print(s));
    }

    private static int calculateBombPower(ArrayList<Character> battlefield,
                                          int startIndex, int endIndex) {

        int bombPower = 0;

        for (int i = startIndex + 1; i < endIndex; i++) {

            bombPower += battlefield.get(i);
        }

        bombPower = bombPower % 10;
        return bombPower;
    }

    private static void detonateBomb(ArrayList<Character> battlefield,
                                     int startIndex, int endIndex, int bombPower) {

        startIndex = startIndex - bombPower < 0 ? 0 : startIndex - bombPower;
        endIndex = endIndex + bombPower >= battlefield.size() ? battlefield.size() - 1 :
                endIndex + bombPower;

        for (int i = startIndex; i <= endIndex; i++) {

            battlefield.set(i, '.');
        }
    }
}
