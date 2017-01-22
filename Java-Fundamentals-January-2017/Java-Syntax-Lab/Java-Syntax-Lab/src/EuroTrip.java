import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double quantity = Double.valueOf(scanner.nextLine());
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInBGN = new BigDecimal(1.20 * quantity);

        BigDecimal totalPrice = exchangeRate.multiply(priceInBGN);
        System.out.printf("%.2f marks", totalPrice);
    }
}
