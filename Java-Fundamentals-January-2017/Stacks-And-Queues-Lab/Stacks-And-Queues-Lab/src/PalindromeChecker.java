import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("");

        ArrayDeque<String> deque = new ArrayDeque<>();
        Collections.addAll(deque, tokens);

        boolean isPalindrome = true;

        while (deque.size() > 1) {

            String firstElement = deque.pollFirst();
            String lastElement = deque.pollLast();

            if (!firstElement.equals(lastElement)) {

                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    }
}
