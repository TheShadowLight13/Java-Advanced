import java.util.Scanner;
import java.util.Stack;

public class StackFibonacci {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = Integer.valueOf(console.nextLine());

        Stack<Long> fibonacciNumbers = new Stack<>();
        fibonacciNumbers.push(1L);
        fibonacciNumbers.push(1L);

        for (int i = 0; i < n - 1; i++) {

            long currFibonacci = fibonacciNumbers.pop();
            long previousFibonacci = fibonacciNumbers.pop();
            long nextFibonacci = currFibonacci + previousFibonacci;

            fibonacciNumbers.push(currFibonacci);
            fibonacciNumbers.push(nextFibonacci);

        }

        long resultNumber = fibonacciNumbers.peek();
        System.out.println(resultNumber);

    }
}
