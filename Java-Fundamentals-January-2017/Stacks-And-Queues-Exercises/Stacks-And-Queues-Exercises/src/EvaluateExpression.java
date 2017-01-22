import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluateExpression {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayList<String> postfixOutput = performPostfix(tokens);
        evaluatePostfixResult(postfixOutput);
    }

    private static void evaluatePostfixResult(ArrayList<String> postfixOutput) {

        Pattern pattern = Pattern.compile("[\\d]+(?:[\\.]*[\\d]+|[\\d]*)");
        ArrayDeque<Double> values = new ArrayDeque<>();

        for (int i = 0; i < postfixOutput.size(); i++) {

            String currToken = postfixOutput.get(i);
            Matcher matcher = pattern.matcher(currToken);

            if (matcher.matches()) {

                values.push(Double.valueOf(currToken));
            }else {

               Double secondOperand = values.pop();
               Double firstOperand = values.pop();

               Double result = 0D;

               switch (currToken) {

                   case "^":
                       result = Math.pow(firstOperand, secondOperand); break;
                   case "+":
                       result = firstOperand + secondOperand; break;
                   case "-":
                       result = firstOperand - secondOperand; break;
                   case "*":
                       result = firstOperand * secondOperand; break;
                   case "/":
                       result = firstOperand / secondOperand; break;
                   case "%":
                       result = firstOperand % secondOperand; break;
               }

                values.push(result);
            }
        }

        System.out.printf("%.2f", values.pop());
    }

    @SuppressWarnings("Duplicates")
    private static ArrayList<String> performPostfix(String[] tokens) {

        ArrayList<String> postfixOutput = new ArrayList<>();

        // Implement Shunting-yard algorithm
        Pattern numberPattern = Pattern.compile("[\\d]+(?:[\\.]*[\\d]+|[\\d]*)");
        ArrayList<String> openingBrackets = new ArrayList<>(Arrays.asList("(", "{", "["));
        ArrayList<String> closingBrackets = new ArrayList<>(Arrays.asList(")", "}", "]"));

        ArrayDeque<String> operatorsStack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {

            String currToken = tokens[i];

            Matcher matcher = numberPattern.matcher(currToken);
            if (matcher.matches()) {

                postfixOutput.add(currToken);
                //System.out.printf("%s ", currToken);
            } else if (openingBrackets.contains(currToken)) {

                operatorsStack.push(currToken);
            } else if (closingBrackets.contains(currToken)) {

                while (operatorsStack.size() > 0) {

                    String tokenFromStack = operatorsStack.pop();

                    if (openingBrackets.contains(tokenFromStack)) {

                        break;
                    }

                    postfixOutput.add(tokenFromStack);
                    //System.out.printf("%s ", tokenFromStack);
                }

            } else {

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
                    postfixOutput.add(operatorFromStack);
                    //System.out.printf("%s ", operatorFromStack);
                }

                operatorsStack.push(currToken);
            }
        }

        while (operatorsStack.size() > 0) {

            postfixOutput.add(operatorsStack.pop());
            //System.out.printf("%s ", operatorsStack.pop());
        }

        return postfixOutput;
    }
}


