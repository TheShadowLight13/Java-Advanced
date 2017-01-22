import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next();
        String secondWord = scanner.next();

        int firstLen = firstWord.length();
        int secondLen = secondWord.length();

        int smallerLen = Math.min(firstLen, secondLen);

        int totalSum = 0;

        for (int i = 0; i < smallerLen; i++) {

            totalSum += (firstWord.charAt(i) * secondWord.charAt(i));
        }

        String biggerWord = " ";
        if (firstLen > secondLen) {

            biggerWord = firstWord;
        }else if (secondLen > firstLen) {

            biggerWord = secondWord;
        }

        if (!biggerWord.equals(" ")) {

            for (int i = smallerLen; i < biggerWord.length(); i++) {

                totalSum += biggerWord.charAt(i);
            }
        }

        System.out.println(totalSum);

    }
}
