import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");

        // Implement Shunting-yard algorithm
        Pattern numberPattern = Pattern.compile("[\\d]+(?:[\\.]*[\\d]+|[\\d]*)");
        ArrayList<String> openingBrackets = new ArrayList<>(Arrays.asList("(", "{", "["));
        ArrayList<String> closingBrackets = new ArrayList<>(Arrays.asList(")", "}", "]"));

        ArrayDeque<String> operatorsStack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {

            String currToken = tokens[i];

            Matcher matcher = numberPattern.matcher(currToken);
            if (matcher.matches()) {

                System.out.printf("%s ", currToken);
            }else if (openingBrackets.contains(currToken)) {

                operatorsStack.push(currToken);
            }else if (closingBrackets.contains(currToken)){

                while (operatorsStack.size() > 0) {

                    String tokenFromStack = operatorsStack.pop();

                    if (openingBrackets.contains(tokenFromStack)){

                        break;
                    }

                    System.out.printf("%s ", tokenFromStack);
                }

            }else {

                ArrayList<String> equalOrGreaterPriority = new ArrayList<>(
                        Arrays.asList("^", "+", "-", "*", "/", "%"));

                switch (currToken) {

                    case "^":
                        equalOrGreaterPriority = new ArrayList<>();
                        break;

                    case "%":
                    case "/":
                    case "*":
                        equalOrGreaterPriority.remove("+");
                        equalOrGreaterPriority.remove("-");
                        break;
                }

                while (operatorsStack.size() > 0) {

                    String operatorFromStack = operatorsStack.peek();

                    if (!equalOrGreaterPriority.contains(operatorFromStack)) {

                        break;
                    }

                    operatorsStack.pop();
                    System.out.printf("%s ", operatorFromStack);
                }

                operatorsStack.push(currToken);
            }
        }

        while (operatorsStack.size() > 0) {

            System.out.printf("%s ", operatorsStack.pop());
        }
    }
}
