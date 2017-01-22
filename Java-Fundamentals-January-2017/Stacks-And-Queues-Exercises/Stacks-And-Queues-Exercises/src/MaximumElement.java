import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            String[] commands = scanner.nextLine().split(" ");
            int commandType = Integer.valueOf(commands[0]);

            if (commandType == 1) {

                int number = Integer.valueOf(commands[1]);
                stack.push(number);

                if (number > maxNumber) {

                    maxNumber = number;
                    maxStack.push(maxNumber);
                }

            }else if (commandType == 2){

                int poppedNumber = stack.pop();

                if (poppedNumber == maxNumber) {

                    maxStack.pop();

                    if (maxStack.size() != 0) {

                        maxNumber = maxStack.peek();
                    }else {

                        maxNumber = Integer.MIN_VALUE;
                    }
                }

            }else if (commandType == 3){

                System.out.println(maxNumber);
            }
        }
    }
}
