import java.util.HashMap;
import java.util.Scanner;

public class CountSameValuesinArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strNumbers = scanner.nextLine().split(" ");

        HashMap<String, Integer> occurencesStrNumber = new HashMap<>();

        for (int i = 0; i < strNumbers.length; i++) {

            String currStrNumber = strNumbers[i];

            if (!occurencesStrNumber.containsKey(currStrNumber)) {

                occurencesStrNumber.put(currStrNumber, 0);
            }

            occurencesStrNumber.put(currStrNumber, occurencesStrNumber.get(currStrNumber) + 1);
        }

        for (String strNumber : occurencesStrNumber.keySet()) {

            System.out.printf("%s - %d times%n", strNumber, occurencesStrNumber.get(strNumber));
        }
    }
}
