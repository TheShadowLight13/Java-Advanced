import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            char currToken = input.charAt(i);

            if (currToken == '(') {

                stack.push(i);
            }else if (currToken == ')'){

                int startIndex = stack.pop();
                int endIndex = i + 1;

                System.out.println(input.substring(startIndex, endIndex));
            }
        }
    }
}
