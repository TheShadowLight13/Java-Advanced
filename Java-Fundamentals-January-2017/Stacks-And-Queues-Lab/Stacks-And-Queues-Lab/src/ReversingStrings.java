import java.util.ArrayDeque;
import java.util.Scanner;

public class ReversingStrings {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {

            stack.push(input.charAt(i));
        }

        while (stack.size() > 0) {

            System.out.printf("%s", stack.pop());
        }
    }
}
