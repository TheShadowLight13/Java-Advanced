import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        TreeMap<Character, Integer> countBySymbol = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {

            char currentSymbol = input.charAt(i);

            if (!countBySymbol.containsKey(currentSymbol)) {

                countBySymbol.put(currentSymbol, 0);
            }

            int symbolCount = countBySymbol.get(currentSymbol) + 1;
            countBySymbol.put(currentSymbol, symbolCount);
        }

        for (Map.Entry<Character, Integer> entry : countBySymbol.entrySet()) {

            System.out.printf("%s: %d time/s\n", entry.getKey(), entry.getValue());
        }
    }
}
