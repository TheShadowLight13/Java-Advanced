import java.util.Scanner;

public class ReadInput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next();
        String secondWord = scanner.next();

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();

        int sum = (firstNum + secondNum + thirdNum);

        scanner.nextLine();

        String thirdWord = scanner.nextLine();
        System.out.printf("%s %s %s %d", firstWord, secondWord, thirdWord, sum);
    }
}
