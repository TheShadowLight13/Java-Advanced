import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {

            char currSymbol = input.charAt(i);

            if (currSymbol == '{' || currSymbol == '[' || currSymbol == '(') {

                stack.push(currSymbol);
            }else {

                switch (currSymbol) {

                    case '}': currSymbol = '{'; break;
                    case ']': currSymbol = '['; break;
                    case ')': currSymbol = '('; break;
                }

                if (stack.size() > 0 && currSymbol == stack.peek()) {

                    stack.pop();
                }else {
                    isBalanced = false;
                    break;
                }
            }
        }

       if (isBalanced) {

           System.out.println("YES");
       }else {

           System.out.println("NO");
       }
    }
}
