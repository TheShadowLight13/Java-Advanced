import java.util.Scanner;

public class RecursiveFibonacci {

    private static long[] memo;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = Integer.valueOf(console.nextLine());

        memo = new long[n + 1];

        long fibonacciN = getFibonacci(n);
        System.out.println(fibonacciN);
    }

    private static long getFibonacci(int n) {

        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {

            return memo[n];
        }

        memo[n] = getFibonacci(n - 1) + getFibonacci(n - 2);

        return memo[n];
    }
}
