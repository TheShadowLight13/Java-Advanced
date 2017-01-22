import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BigInteger product = BigInteger.ONE;

        for (int i = n; i <= m; i++) {

            product = product.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.printf("product[%d..%d] = %d", n, m, product);
    }
}
